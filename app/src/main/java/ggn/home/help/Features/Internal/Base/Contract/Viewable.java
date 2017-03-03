package ggn.home.help.Features.Internal.Base.Contract;

/**
 * Android contract for every MVP View
 */
public interface Viewable<T>
{

    /**
     * initialize all views
     */
    void initViews();

    /**
     * Every Viewable must be able to access to its attached Presenter
     *
     * @return Presentable
     */
    T getPresenter();

    /**
     * Every Viewable must be able to inject its Presenter
     *
     * @param presenter Presentable
     */
    void injectPresenter(T presenter);

    /**
     * Every Viewable must have a error message system
     */
    void displayError(String message);

    /**
     * Every Viewable must implement one show loading feature
     */
    void showLoading();

    /**
     * Every Viewable must implement one hide loading feature
     */
    void hideLoading();

}
