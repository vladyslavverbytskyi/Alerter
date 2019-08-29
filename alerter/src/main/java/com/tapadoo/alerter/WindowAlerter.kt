package com.tapadoo.alerter

import android.graphics.Bitmap
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import java.lang.ref.WeakReference

/**
 * Alert helper class. Will attach a temporary layout to the content of view of window provider, on top of
 * all other views. It should appear under the status bar.
 *
 * @author Kevin Murphy
 * @since 03/11/2015.
 */
class WindowAlerter private constructor() {

    /**
     * Sets the Alert
     *
     * @param alert The Alert to be references and maintained
     */
    private var alert: Alert? = null

    /**
     * Get the enclosing Decor View
     *
     * @return The Decor View of the WindowProvider's implementation the Alerter was called from
     */
    private val decorView: ViewGroup?
        get() {
            var decorView: ViewGroup? = null

            windowWeakReference?.get()?.let {
                decorView = it.provideWindow().decorView as ViewGroup
            }

            return decorView
        }

    private val mainHandler = Handler(Looper.getMainLooper())

    /**
     * Shows the Alert, after it's built
     *
     * @return An Alert object check can be altered or hidden
     */
    fun show(): Alert? {
        //This will get the Activity Window's DecorView
        windowWeakReference?.get()?.let {
            mainHandler.post {
                //Add the new Alert to the View Hierarchy
                decorView?.addView(alert)
            }
        }

        return alert
    }

    /**
     * Sets the title of the Alert
     *
     * @param titleId Title String Resource
     * @return This Alerter
     */
    fun setTitle(@StringRes titleId: Int): WindowAlerter {
        alert?.setTitle(titleId)

        return this
    }

    /**
     * Set Title of the Alert
     *
     * @param title Title as a CharSequence
     * @return This Alerter
     */
    fun setTitle(title: CharSequence): WindowAlerter {
        alert?.setTitle(title)

        return this
    }

    /**
     * Set the Title's Typeface
     *
     * @param typeface Typeface to use
     * @return This Alerter
     */
    fun setTitleTypeface(typeface: Typeface): WindowAlerter {
        alert?.setTitleTypeface(typeface)

        return this
    }

    /**
     * Set the Title's text appearance
     *
     * @param textAppearance The style resource id
     * @return This Alerter
     */
    fun setTitleAppearance(@StyleRes textAppearance: Int): WindowAlerter {
        alert?.setTitleAppearance(textAppearance)

        return this
    }

    /**
     * Set Gravity of the Alert
     *
     * @param gravity Gravity of Alert
     * @return This Alerter
     */
    fun setContentGravity(gravity: Int): WindowAlerter {
        alert?.contentGravity = gravity

        return this
    }

    /**
     * Sets the Alert Text
     *
     * @param textId Text String Resource
     * @return This Alerter
     */
    fun setText(@StringRes textId: Int): WindowAlerter {
        alert?.setText(textId)

        return this
    }

    /**
     * Sets the Alert Text
     *
     * @param text CharSequence of Alert Text
     * @return This Alerter
     */
    fun setText(text: CharSequence): WindowAlerter {
        alert?.setText(text)

        return this
    }

    /**
     * Set the Text's Typeface
     *
     * @param typeface Typeface to use
     * @return This Alerter
     */
    fun setTextTypeface(typeface: Typeface): WindowAlerter {
        alert?.setTextTypeface(typeface)

        return this
    }

    /**
     * Set the Text's text appearance
     *
     * @param textAppearance The style resource id
     * @return This Alerter
     */
    fun setTextAppearance(@StyleRes textAppearance: Int): WindowAlerter {
        alert?.setTextAppearance(textAppearance)

        return this
    }

    /**
     * Set the Alert's Background Colour
     *
     * @param colorInt Colour int value
     * @return This Alerter
     */
    fun setBackgroundColorInt(@ColorInt colorInt: Int): WindowAlerter {
        alert?.setAlertBackgroundColor(colorInt)

        return this
    }

    /**
     * Set the Alert's Background Colour
     *
     * @param colorResId Colour Resource Id
     * @return This Alerter
     */
    fun setBackgroundColorRes(@ColorRes colorResId: Int): WindowAlerter {
        windowWeakReference?.get()?.let {
            alert?.setAlertBackgroundColor(ContextCompat.getColor(it.provideWindow().context, colorResId))
        }

        return this
    }

    /**
     * Set the Alert's Background Drawable
     *
     * @param drawable Drawable
     * @return This Alerter
     */
    fun setBackgroundDrawable(drawable: Drawable): WindowAlerter {
        alert?.setAlertBackgroundDrawable(drawable)

        return this
    }

    /**
     * Set the Alert's Background Drawable Resource
     *
     * @param drawableResId Drawable Resource Id
     * @return This Alerter
     */
    fun setBackgroundResource(@DrawableRes drawableResId: Int): WindowAlerter {
        alert?.setAlertBackgroundResource(drawableResId)

        return this
    }

    /**
     * Set the Alert's Icon
     *
     * @param iconId The Drawable's Resource Idw
     * @return This Alerter
     */
    fun setIcon(@DrawableRes iconId: Int): WindowAlerter {
        alert?.setIcon(iconId)

        return this
    }

    /**
     * Set the Alert's Icon
     *
     * @param bitmap The Bitmap object to use for the icon.
     * @return This Alerter
     */
    fun setIcon(bitmap: Bitmap): WindowAlerter {
        alert?.setIcon(bitmap)

        return this
    }

    /**
     * Set the Alert's Icon
     *
     * @param drawable The Drawable to use for the icon.
     * @return This Alerter
     */
    fun setIcon(drawable: Drawable): WindowAlerter {
        alert?.setIcon(drawable)

        return this
    }

    /**
     * Set the icon color for the Alert
     *
     * @param color Color int
     * @return This Alerter
     */
    fun setIconColorFilter(@ColorInt color: Int): WindowAlerter {
        alert?.setIconColorFilter(color)

        return this
    }

    /**
     * Set the icon color for the Alert
     *
     * @param colorFilter ColorFilter
     * @return This Alerter
     */
    fun setIconColorFilter(colorFilter: ColorFilter): WindowAlerter {
        alert?.setIconColorFilter(colorFilter)

        return this
    }

    /**
     * Set the icon color for the Alert
     *
     * @param color Color int
     * @param mode  PorterDuff.Mode
     * @return This Alerter
     */
    fun setIconColorFilter(@ColorInt color: Int, mode: PorterDuff.Mode): WindowAlerter {
        alert?.setIconColorFilter(color, mode)

        return this
    }

    /**
     * Hide the Icon
     *
     * @return This Alerter
     */
    fun hideIcon(): WindowAlerter {
        alert?.showIcon(false)

        return this
    }

    /**
     * Set the onClickListener for the Alert
     *
     * @param onClickListener The onClickListener for the Alert
     * @return This Alerter
     */
    fun setOnClickListener(onClickListener: View.OnClickListener): WindowAlerter {
        alert?.setOnClickListener(onClickListener)

        return this
    }

    /**
     * Set the on screen duration of the alert
     *
     * @param milliseconds The duration in milliseconds
     * @return This Alerter
     */
    fun setDuration(milliseconds: Long): WindowAlerter {
        alert?.duration = milliseconds

        return this
    }

    /**
     * Enable or Disable Icon Pulse Animations
     *
     * @param pulse True if the icon should pulse
     * @return This Alerter
     */
    fun enableIconPulse(pulse: Boolean): WindowAlerter {
        alert?.pulseIcon(pulse)

        return this
    }

    /**
     * Set whether to show the icon in the alert or not
     *
     * @param showIcon True to show the icon, false otherwise
     * @return This Alerter
     */
    fun showIcon(showIcon: Boolean): WindowAlerter {
        alert?.showIcon(showIcon)

        return this
    }

    /**
     * Enable or disable infinite duration of the alert
     *
     * @param infiniteDuration True if the duration of the alert is infinite
     * @return This Alerter
     */
    fun enableInfiniteDuration(infiniteDuration: Boolean): WindowAlerter {
        alert?.setEnableInfiniteDuration(infiniteDuration)

        return this
    }

    /**
     * Sets the Alert Shown Listener
     *
     * @param listener OnShowAlertListener of Alert
     * @return This Alerter
     */
    fun setOnShowListener(listener: OnShowAlertListener): WindowAlerter {
        alert?.setOnShowListener(listener)

        return this
    }

    /**
     * Sets the Alert Hidden Listener
     *
     * @param listener OnHideAlertListener of Alert
     * @return This Alerter
     */
    fun setOnHideListener(listener: OnHideAlertListener): WindowAlerter {
        alert?.onHideListener = listener

        return this
    }

    /**
     * Enables swipe to dismiss
     *
     * @return This Alerter
     */
    fun enableSwipeToDismiss(): WindowAlerter {
        alert?.enableSwipeToDismiss()

        return this
    }

    /**
     * Enable or Disable Vibration
     *
     * @param enable True to enable, False to disable
     * @return This Alerter
     */
    fun enableVibration(enable: Boolean): WindowAlerter {
        alert?.setVibrationEnabled(enable)

        return this
    }

    /**
     * Disable touch events outside of the Alert
     *
     * @return This Alerter
     */
    fun disableOutsideTouch(): WindowAlerter {
        alert?.disableOutsideTouch()

        return this
    }

    /**
     * Enable or disable progress bar
     *
     * @param enable True to enable, False to disable
     * @return This Alerter
     */
    fun enableProgress(enable: Boolean): WindowAlerter {
        alert?.setEnableProgress(enable)

        return this
    }

    /**
     * Set the Progress bar color from a color resource
     *
     * @param color The color resource
     * @return This Alerter
     */
    fun setProgressColorRes(@ColorRes color: Int): WindowAlerter {
        alert?.setProgressColorRes(color)

        return this
    }

    /**
     * Set the Progress bar color from a color resource
     *
     * @param color The color resource
     * @return This Alerter
     */
    fun setProgressColorInt(@ColorInt color: Int): WindowAlerter {
        alert?.setProgressColorInt(color)

        return this
    }

    /**
     * Set if the Alert is dismissable or not
     *
     * @param dismissable true if it can be dismissed
     * @return This Alerter
     */
    fun setDismissable(dismissable: Boolean): WindowAlerter {
        alert?.setDismissible(dismissable)

        return this
    }

    /**
     * Set a Custom Enter Animation
     *
     * @param animation The enter animation to play
     * @return This Alerter
     */
    fun setEnterAnimation(@AnimRes animation: Int): WindowAlerter {
        alert?.enterAnimation = AnimationUtils.loadAnimation(alert?.context, animation)

        return this
    }

    /**
     * Set a Custom Exit Animation
     *
     * @param animation The exit animation to play
     * @return This Alerter
     */
    fun setExitAnimation(@AnimRes animation: Int): WindowAlerter {
        alert?.exitAnimation = AnimationUtils.loadAnimation(alert?.context, animation)

        return this
    }

    /**
     * Show a button with the given text, and on click listener
     *
     * @param text The text to display on the button
     * @param onClick The on click listener
     */
    fun addButton(
            text: CharSequence, @StyleRes style: Int = R.style.AlertButton,
            onClick: View.OnClickListener
    ): WindowAlerter {
        alert?.addButton(text, style, onClick)

        return this
    }

    /**
     * Set the Button's Typeface
     *
     * @param typeface Typeface to use
     * @return This Alerter
     */
    fun setButtonTypeface(typeface: Typeface): WindowAlerter {
        alert?.buttonTypeFace = typeface

        return this
    }

    /**
     * Creates a weak reference to the calling WindowProvider
     *
     * @param windowProvider The calling WindowProvider
     */
    private fun setWindowProvider(windowProvider: WindowProvider) {
        windowWeakReference = WeakReference(windowProvider)
    }

    companion object {

        private var windowWeakReference: WeakReference<WindowProvider>? = null

        /**
         * Creates the Alert, and maintains a reference to the calling WindowProvider
         *
         * @param windowProvider The calling WindowProvider
         * @return This Alerter
         */
        @JvmStatic
        fun create(windowProvider: WindowProvider?): WindowAlerter {
            if (windowProvider == null) {
                throw IllegalArgumentException("Activity cannot be null!")
            }

            val alerter = WindowAlerter()

            //Hide current Alert, if one is active
            clearCurrent(windowProvider)

            alerter.setWindowProvider(windowProvider)
            alerter.alert = Alert(windowProvider.provideWindow().context)

            return alerter
        }

        /**
         * Cleans up the currently showing alert view, if one is present
         *
         * @param windowProvider The current WindowProvider
         */
        @JvmStatic
        fun clearCurrent(windowProvider: WindowProvider) {
            (windowProvider.provideWindow().decorView as? ViewGroup)?.let {
                //Find all Alert Views in Parent layout
                for (i in 0..it.childCount) {
                    val childView = if (it.getChildAt(i) is Alert) it.getChildAt(i) as Alert else null
                    if (childView != null && childView.windowToken != null) {
                        ViewCompat.animate(childView).alpha(0f).withEndAction(getRemoveViewRunnable(childView))
                    }
                }
            }
        }

        /**
         * Hides the currently showing alert view, if one is present
         */
        @JvmStatic
        fun hide() {
            windowWeakReference?.get()?.let {
                clearCurrent(it)
            }
        }

        /**
         * Check if an Alert is currently showing
         *
         * @return True if an Alert is showing, false otherwise
         */
        @JvmStatic
        val isShowing: Boolean
            get() {
                var isShowing = false

                windowWeakReference?.get()?.let {
                    isShowing = it.provideWindow().findViewById<View>(R.id.llAlertBackground) != null
                }

                return isShowing
            }

        private fun getRemoveViewRunnable(childView: Alert?): Runnable {
            return Runnable {
                childView?.let {
                    (childView.parent as? ViewGroup)?.removeView(childView)
                }
            }
        }
    }
}
