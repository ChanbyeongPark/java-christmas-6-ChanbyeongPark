# 크리스마스 프로모션
## 기능 목록
- [X] 방문 예상 날짜를 입력 받음 - InputView#inputDate()
  - [X] 입력 예외 처리 - ChristmasController#inputDate()
    - [X] 숫자(정수)가 아닌 경우 - InputView#converToInt()
    - [X] 1 이상 31 이하의 숫자가 아닌 경우 - VisitDate#validateDate()
- [X] 주문 메뉴와 개수를 입력 받음 - InputView#inputMenus()
  - [X] 입력 예외 처리 - ChristmasController#inputMenus()
    - [X] 입력 형식에 맞지 않는 경우(메뉴-개수,메뉴-개수, ...)
      - [X] 콤마(,) 기준으로 분리해서 메뉴-개수 단위로 분리 - OrderMenus#separateMenus()
      - [X] 대시(-) 기준으로 분리해서 메뉴와 개수도 분리 - OrderMenus#separateMenu()
      - [X] 최종 형식이 (메뉴, 개수), (메뉴, 개수), ... 가 아닌 경우 예외처리 - OrderMenus#validateSizeMenu()
    - [X] 메뉴판에 없는 메뉴가 있는 경우 - OrderMenus#validateExistMenu()
    - [X] 각 메뉴의 개수가 1 이상의 정수가 아닌 경우 - OrderMenus#validateNumberMenu()
      - [X] 숫자(정수)가 아닌 경우 - OrderMenus#convertToInt()
      - [X] 1 이상의 숫자가 아닌 경우 - OrderMenus#validateMinNumberMenu()
    - [X] 메뉴가 중복으로 입력된 경우 - OrderMenus#validateNotDuplicateMenus()
    - [X] 주문 메뉴의 총 개수가 20을 넘는 경우 - OrderMenus#validateMaxTotalNumMenus()
    - [X] 음료만 주문한 경우 - OrderMenus#validateNotOnlyBeverageMenus()
- [X] 방문 예정 날짜를 포함한 안내문 출력 - OutputView#printResultStart()
- [X] 주문 메뉴 출력 - OutputView#printMenus()
- [X] 할인 전 총 주문 금액 출력(숫자 3개 당 콤마(,) 포함해서 출력) - OutputView#printTotalPriceBeforeDiscount()
- [X] 증정 메뉴 출력(할인 전 총 주문 금액이 12만원 이상인 경우 증정) - OutputView#printFreeGift()
  - [X] 없다면 `없음`출력 - OutputView#getFreeGift()
- [X] 혜택 내역 출력
  - [X] 할인 전 총 주문 금액이 10,000원 이하라면 할인을 적용하지 않음 - flag 도입
  - [X] 크리스마스 디데이 할인(1일~25일 날짜에 따른 할인) - DDayDiscount#calculateDDayDiscount()
    - [X] 1~25일인지 판단
    - [X] 할인 금액 판단(1,000 + 100*(날짜-1))
  - [X] 평일 할인(일~목, 디저트 메뉴 1개당 2,023원 할인) - WeekdayDiscount#calculateWeekdayDiscount()
    - [X] 일~목인지 판단 - WeekdayDiscount#whetherWeekday()
    - [X] 디저트 메뉴 판단 - WeekdayDiscount#calDessertNumMenus()
  - [X] 주말 할인(금~토, 메인 메뉴 1개당 2,023원 할인) - WeekendDiscount#calculateWeekendDiscount()
    - [X] 금~토인지 판단 - WeekendDiscount#whetherWeekend()
    - [X] 메인 메뉴 판단 - WeekendDiscount#calMainNumMenus()
  - [X] 특별 할인(일 또는 크리스마스라면 1,000원 할인) - SpecialDiscount#calculateSpecialDiscoun()
    - [X] 크리스마스인지 판단 - SpecialDiscount#whetherSunday()
    - [X] 일요일인지 판단 - SpecialDiscount#whetherChristmas()
  - [X] 증정 이벤트(증정이 있다면 샴페인 가격 25,000원을 할인으로 취급하고 출력) - FreeGiftDiscount#calculateFreeGiftDiscount()
  - [X] 없다면 `없음` 출력
- [X] 총혜택 금액 출력 - OutputView#printTotalDiscount()
- [X] 할인 후 예상 결제 금액 출력(숫자 3자리 단위 콤마(,) 포함 출력) - OutputView#printTotalPriceAfterDiscount()
- [X] 12월 이벤트 배지 출력(총혜택 금액에 따라 5,000~: 별, 10,000~: 트리, 20,000~: 산타) - OutputView#printEventBadge()
  - [X] 없다면 `없음` 출력

## '12월 이벤트 플래너'의 흐름
고객들이 식당에 `방문할 날짜와 메뉴`를 선택하면 `주문메뉴, 할인 전 총 주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지`정보를 보여주기를 기대
- 12월 식당 방문 예상 날짜 입력 받음(1이상 31이하의 숫자가 아니라면 에러 출력 후 다시 입력 받기)
- 주문 메뉴와 개수 입력 받음(메뉴판에 없는 메뉴, 메뉴의 개수가 1미만, 형식이 다른 경우, 중복되는 입력의 경우에는 에러 출력 후 다시 입력 받기)
- 주문 메뉴 출력(순서는 자유)
- 할인 전 총 주문 금액 출력
- 증정 메뉴 출력(없다면 없음 출력)
- 혜택 내역 출력(없다면 없음 출력)
- 총혜택 금액 출력(없다면 0원 출력)
- 할인 후 예상 결제 금액 출력
- 12월 이벤트 배지 출력(없다면 없음 출력)

## 기능 요구 사항
- 2023년 12월 식당 이벤트 개최, 예산은 무제한
- 메뉴 목록
```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```
- 중복된 할인과 증정 허용
- 최고의 판매 금액 달성
- 이번 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 참여하길 기대

- 이벤트 계획(디데이 할인을 제외하고 12월 내내 적용)
  - 크리스마스 디데이 할인: 1일부터 25일까지 1,000원으로 시작하여 매일 할인 금액이 100원씩 증가. 총 주문 금액에서 해당 금액만큼 할인(1일: 1,000원 할인, ..., 25일: 3,400원 할인)
  - 평일 할인: `일요일 ~ 목요일`에는 디저트 메뉴 1개당 2,023원 할인
  - 주말 할인: `금요일, 토요일`에는 메인 메뉴 1개당 2,023원 할인
  - 특별 할인: 달력에 별이 있는 날(매주 일요일과 크리스마스 당일)에는 총주문 금액에서 1,000원 할인
  - 증정 이벤트: 할인 전 총주문 금액이 12만원 이상이면 샴페인 1개 증정
- 총 혜택 금액에 따른 이벤트 배지 부여 - 내년 새해 이벤트 참여시 선물 증정
  - 5천원 이상: 별
  - 1만원 이상: 트리
  - 2만원 이상: 산타
- 이벤트 주의 사항
  - 총 주문 금액 10,000원 이상부터 이벤트 적용
  - 음료만 주문 불가
  - 주문 메뉴의 총 개수는 최대 20개