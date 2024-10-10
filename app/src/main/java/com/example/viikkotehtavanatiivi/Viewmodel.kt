import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {


    var heightInput = mutableStateOf("")
    var weightInput = mutableStateOf("")


    val bmi = mutableStateOf(0.0f)


    fun onHeightChange(newHeight: String) {
        heightInput.value = newHeight.replace(",", ".")
        calculateBmi()
    }


    fun onWeightChange(newWeight: String) {
        weightInput.value = newWeight.replace(",", ".")
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.value.toFloatOrNull() ?: 0.0f
        val weight = weightInput.value.toIntOrNull() ?: 0
        bmi.value = if (height > 0 && weight > 0) weight / (height * height) else 0.0f
    }
}
