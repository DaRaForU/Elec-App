package kh.edu.rupp.ite.elec_app.model.model

data class ApiData<T>(
    val status: Status,
    val data: T?
)

enum class Status{
    PROCESSING, SUCCESS, ERROR
}
