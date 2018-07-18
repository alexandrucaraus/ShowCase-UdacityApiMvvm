package eu.caraus.dynamo.application.service.udacity;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import eu.caraus.dynamo.application.domain.udacity.UdacityCourses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UdacityCoursesServiceTest {

    @Test
    public void getUdacityCoursesBasicTest() {

        final Object lock = new Object();

        UdacityCoursesService service = new UdacityCoursesService();

        service.getUdacityCourses(new UdacityCoursesService.UdacityCoursesCallback() {
            @Override
            public void onData(UdacityCourses courses) {

                assertThat("isSuccess", is("isSuccess"));

                synchronized ( lock ){
                    lock.notify();
                }
            }

            @Override
            public void onDataError(String error) {

                assertThat("failed " + error, is("isNotFailed"));

                synchronized ( lock ){
                    lock.notify();
                }

            }

            @Override
            public void onFailure(Throwable throwable) {

                assertThat("failed " + throwable.getMessage(), is("isNotFailed"));

                synchronized ( lock ){
                    lock.notify();
                }
            }
        });

        synchronized ( lock ) {
            try { lock.wait(); } catch ( InterruptedException e ) { e.printStackTrace(); }
        }

    }


}
