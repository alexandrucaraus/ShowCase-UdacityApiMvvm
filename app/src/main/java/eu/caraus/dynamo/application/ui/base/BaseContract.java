package eu.caraus.dynamo.application.ui.base;

public interface BaseContract {

    interface BasePresenter <T extends BaseView> {

        void onViewAttached(T view);
        void onViewDetached(boolean detach);

    }

    interface BaseView {

    }

}