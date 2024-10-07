# Readable Code

[Readable Code: 읽기 좋은 코드를 작성하는 사고법](https://inf.run/kHiWM)

2024.10.07
### 섹션4
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
SRP 지키기 위해 InputHandler, OutputHandler, GameBoard 객체로 리팩토링  
OCP 지키기 위해 GameLevel interface를 통해 MineSweeper 생성
LSP 를 지키면서 Cell을 추상클래스로 Refactoring