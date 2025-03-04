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
