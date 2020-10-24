package oldstudy.designpatterns.singleton;

public class innerTest {

    private static innerTest instance;


    private innerTest() {
    }


    public innerTest getInstance() {

        if (instance == null) {

            synchronized (innerTest.this) {
                if (instance == null) {
                    instance = new innerTest();

                }
            }
        }
        return instance;
    }

}


