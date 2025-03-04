# Transaction #
## Introduction ##
Transaction -> 事務管理，確保方法內的數據處理，完全成功才能提交；不然就是出問題就回滾(rollback)，保證數據的一致性和完整性<br>
<br>
rollback的條件 :<br>
默認 : 拋出RuntimeException或其子類別以及Error -> Spring自動回滾<br>
默認不回滾 : checkedException 或自定義Exception(因為可預料且進行異常處理)，所以默認不回滾<br>
<br>
表示法 :<br>
@Transactional(rollbackFor = Exception.class)// 設定捕捉到哪類的異常就執行回滾

## 流程圖 ##
執行業務邏輯 -> 是否拋出異常? -> 否 -> 正常執行<br>
                            -> 是 -> 判別異常類型? -> RuntimeException 或 Error -> Rollback<br>
                                                    -> CheckedException 或 自定義Exception -> No Rollback<br>
## Software Architecture ##
- src/main/java
  - com.project.david
    - entity
      - Order.java (class)
      - Product.java (class)
    - dao
      - OrderRepository.java (interface)
      - ProductRepository.java (interface)
    - service
      - OrderService.java (interface)
      - ServiceException.java (class)
      - impl
        -OrderServiceImpl.java (class)
    - controller
      -OrderController.java (class)
- src/main/resources
  - static
  - templates
  - application.properties

## Test ##
![Product內的產品資訊](https://drive.google.com/uc?export=view&id=1ESlF1C0i0Q_UxHqqUvccg49aZenUUbbA)<br>
- Product內的產品資訊<br>
![新增一次訂單，新增成功](https://drive.google.com/uc?export=view&id=1u44Ra_uDiWup6kdUrtpqLo4YzHXUsVba)<br>
- 新增一次訂單，新增成功<br>
![新增訂單成功後，商品的庫存減少](https://drive.google.com/uc?export=view&id=1A04YERue_2-cQbg2ozPJda5ML7_DFTCZ)<br>
- 新增訂單成功後，商品的庫存減少<br>
![新增訂單成功後，訂單資訊出現](https://drive.google.com/uc?export=view&id=1LhFecyXd1uVtd0aaNk551uuigUmpU6wt)<br>
- 新增訂單成功後，訂單資訊出現<br>
![再次新增訂單，因為庫存小於訂單內的商品數量，拋出異常，Rollback](https://drive.google.com/uc?export=view&id=1H_NZM80tur-200f7v9OVjdwjweNYn-4n)<br>
- 再次新增訂單，因為庫存小於訂單內的商品數量，拋出異常，Rollback<br>
