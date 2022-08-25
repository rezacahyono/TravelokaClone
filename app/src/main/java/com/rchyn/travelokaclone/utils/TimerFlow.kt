import android.os.CountDownTimer
import android.os.Looper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
class TimerFlow private constructor(millisInFuture: Long, countDownInterval: Long) {

    private val tick: Flow<Long> = callbackFlow {

        if (Looper.myLooper() == null) {
            throw IllegalStateException("Can't create TimerFlow inside thread that has not called Looper.prepare() Just use Dispatchers.Main")
        }

        object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onFinish() {
                trySend(0L).isSuccess
                cancel()
            }

            override fun onTick(millisUntilFinished: Long) {
                trySend(millisUntilFinished).isSuccess
            }
        }.start()

        awaitClose()
    }

    companion object {
        /**
         * Create a [Flow] that will be a countdown until a specified time in the future.
         *
         * @param millisInFuture The milliseconds in the future that this will countdown to.
         * @param countDownInterval The minimum amount of time between emissions.
         */
        @JvmStatic
        fun create(millisInFuture: Long, countDownInterval: Long) =
            TimerFlow(millisInFuture, countDownInterval).tick
    }
}