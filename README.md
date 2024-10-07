# Readable Code

[Readable Code: 읽기 좋은 코드를 작성하는 사고법](https://inf.run/kHiWM)

2024.10.07
## 섹션4
Cell 객체 생성으로 인한 리펙토링  
**'열렸다/닫혔다'** 는 개념과, **'사용자가 체크했다'** 는 개념은 다르다.  

```java
    public class Cell {
        // 생략
        private int nearbyLandMineCount;
        private boolean isLandMine;
        private boolean isFlagged;
        private boolean isOpened;

        // 생략


        public String getSign() {
            if (isOpened) {
                if (isLandMine) {
                    return LAND_MINE_SIGN;
                }
    
                if (hasLandMindCount()) {
                    return String.valueOf(nearbyLandMineCount);
                }
    
                return EMPTY_SIGN;
            }
    
            if (isFlagged) {
                return FLAG_SIGN;
            }
    
            return UNCHECKED_SIGN;
        }
    }
```

`Cell` 의 4가지 개념으로 지금 `Cell`의 상태를 `getSign()`으로 그려줌
    
2024.10.08  
### SOLID
SRP 지키기 위해 InputHandler, OutputHandler, GameBoard 객체로 리팩토링  
OCP 지키기 위해 GameLevel interface를 통해 MineSweeper 생성
LSP 를 지키면서 Cell을 추상클래스로 Refactoring 
ISP 를 지키기 위해 GameInitializable, GameRunnable interface로 분리  
DIP 를 지키기 위해 Minesweeper에서는 InputHandler, OutputHandler와 같은 저수준 모듈을 참조한다.    

### DIP (Dependency Inversion Principle)    
- 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안된다. 둘 모두 추상화에 의존해야 한다.

### DI (Dependency Injection) - "3" 
- 필요한 의존성을 내가 직접 생성하는 것이 아니라, **외부에서 주입**받는다.   
- A 객체가 필요한 B라는 객체를 제 3자인 C가 대신 생성하여 주입해줌.
- Spring에서는 Spring Context 가 해줌.

### IoC (Inversion of Control)
- 프로그램의 제어권을 개발자가 아닌 **프레임워크**가 담당하는 것. 
- 제어의 순방향: 개발자가 프로그램을 만듦.
- 제어의 역방향: 개발자가 만든 프로그램이 공장같은 **프레임워크**에서 만들어짐.
- IoC Container가 객체의 생성과 소멸까지 관리해줌.