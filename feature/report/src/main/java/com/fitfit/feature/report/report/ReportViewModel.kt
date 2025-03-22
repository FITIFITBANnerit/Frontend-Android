package com.fitfit.feature.report.report

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.fitfit.core.data.data.repository.ImageRepository
import com.fitfit.core.model.report.ReportLog
import com.fitfit.core.ui.ui.card.MAX_IMAGE_COUNT
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class ReportUiState(
    val showExitDialog: Boolean = false,
    val showSendReportResultDialog: Boolean = false,

    val reportLog: ReportLog = ReportLog(),

    val isPhotoCountOver: Boolean = false,
    val isContentTextLengthOver: Boolean = false,

    val reportButtonEnabled: Boolean = true,

    val sendReportResultIsSuccess: Boolean? = null
)


@HiltViewModel
class ReportViewModel @Inject constructor(
//    private val reportRepository: ReportRepository,
    private val imageRepository: ImageRepository
): ViewModel() {

    private val _reportUiState: MutableStateFlow<ReportUiState> =
        MutableStateFlow(ReportUiState())

    val reportUiState = _reportUiState.asStateFlow()



    //dialog
    fun setShowExitDialog(showExitDialog: Boolean) {
        _reportUiState.update {
            it.copy(showExitDialog = showExitDialog)
        }
    }

    fun setShowSendReportResultDialog(
        showSendReportResultDialog: Boolean
    ) {
        if (!showSendReportResultDialog)
            setSendReportResultIsSuccess(null)

        _reportUiState.update {
            it.copy(showSendReportResultDialog = showSendReportResultDialog)
        }
    }

    //
    fun setSendReportResultIsSuccess(isSuccess: Boolean?){
        _reportUiState.update {
            it.copy(sendReportResultIsSuccess = isSuccess)
        }
    }

    //error
    fun setPhotoCountOver(isImageCountOver: Boolean) {
        _reportUiState.update {
            it.copy(
                isPhotoCountOver = isImageCountOver,
                reportButtonEnabled = !it.isContentTextLengthOver && !isImageCountOver
            )
        }
    }

    fun setContentTextLengthOver(isContentTextLengthOver: Boolean) {
        _reportUiState.update {
            it.copy(
                isContentTextLengthOver = isContentTextLengthOver,
                reportButtonEnabled = !isContentTextLengthOver && !it.isPhotoCountOver
            )
        }
    }

    //report log
    fun setContentText(newContentText: String) {
        _reportUiState.update {
            it.copy(
                reportLog = it.reportLog.copy(content = newContentText)
            )
        }
    }

    fun addPhotos(addedPhotos: List<String>) {
        val newPhotos = _reportUiState.value.reportLog.images + addedPhotos

        _reportUiState.update {
            it.copy(
                reportLog = it.reportLog.copy(
                    images = newPhotos
                )
            )
        }

        setPhotoCountOver(newPhotos.size > MAX_IMAGE_COUNT)
    }

    fun deletePhotos(deletedPhotos: List<String>) {
        val newPhotos = _reportUiState.value.reportLog.images.toMutableList()
        newPhotos.removeAll(deletedPhotos)

        _reportUiState.update {
            it.copy(
                reportLog = it.reportLog.copy(
                    images = newPhotos
                )
            )
        }

        setPhotoCountOver(newPhotos.size > MAX_IMAGE_COUNT)
    }

    fun setLocation(newLocation: LatLng){
        _reportUiState.update {
            it.copy(
                reportLog = it.reportLog.copy(
                    location = newLocation
                )
            )
        }
    }



    //image
    fun saveImageToInternalStorage(
        userId: Int,
        index: Int,
        uri: Uri,
        isProfileImage: Boolean = false
    ): String? {
        return imageRepository.saveImageToInternalStorage(
            userId = userId,
            index = index,
            uri = uri,
            isProfileImage = isProfileImage
        )
    }




}