package com.phisher98;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Switch;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppSettingsSync.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1", f = "AppSettingsSync.kt", i = {1}, l = {447, 454}, m = "invokeSuspend", n = {"deleteRes"}, nl = {448, 456}, s = {"L$0"}, v = 2)
final class UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseDevice $device;
    final /* synthetic */ LayoutInflater $inflater;
    final /* synthetic */ boolean $isCurrent;
    final /* synthetic */ Switch $nameSwitch;
    final /* synthetic */ View $rootView;
    Object L$0;
    int label;
    final /* synthetic */ UltimaConfigureAppSettingsSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1(FirebaseDevice firebaseDevice, boolean z, UltimaConfigureAppSettingsSync ultimaConfigureAppSettingsSync, View view, LayoutInflater layoutInflater, Switch r7, Continuation<? super UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1> continuation) {
        super(2, continuation);
        this.$device = firebaseDevice;
        this.$isCurrent = z;
        this.this$0 = ultimaConfigureAppSettingsSync;
        this.$rootView = view;
        this.$inflater = layoutInflater;
        this.$nameSwitch = r7;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1(this.$device, this.$isCurrent, this.this$0, this.$rootView, this.$inflater, this.$nameSwitch, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0047  */
    /* JADX WARN: Code duplicated, block: B:15:0x0069  */
    /* JADX WARN: Code duplicated, block: B:18:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0091  */
    /* JADX WARN: Code duplicated, block: B:21:0x0094  */
    public final Object invokeSuspend(Object $result) {
        Object objRemoveDevice;
        Pair deleteRes;
        Pair deleteRes2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objRemoveDevice = UltimaSettingsSyncUtils.INSTANCE.removeDevice(this.$device.getDeviceId(), (Continuation) this);
                if (objRemoveDevice == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deleteRes = (Pair) objRemoveDevice;
                if (((Boolean) deleteRes.getFirst()).booleanValue()) {
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Removed " + this.$device.getName(), (Integer) null, 2, (Object) null);
                    if (this.$isCurrent) {
                        this.this$0.sm.setAppSettingsSyncCreds(null);
                        this.this$0.updateLastSyncInfo(this.$rootView);
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(deleteRes);
                    this.label = 2;
                    if (this.this$0.refreshDevicesList(this.$rootView, this.$inflater, null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deleteRes2 = deleteRes;
                } else {
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Failed: " + ((String) deleteRes.getSecond()), (Integer) null, 2, (Object) null);
                    this.$nameSwitch.setChecked(true);
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                objRemoveDevice = $result;
                deleteRes = (Pair) objRemoveDevice;
                if (((Boolean) deleteRes.getFirst()).booleanValue()) {
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Removed " + this.$device.getName(), (Integer) null, 2, (Object) null);
                    if (this.$isCurrent) {
                        this.this$0.sm.setAppSettingsSyncCreds(null);
                        this.this$0.updateLastSyncInfo(this.$rootView);
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(deleteRes);
                    this.label = 2;
                    if (this.this$0.refreshDevicesList(this.$rootView, this.$inflater, null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deleteRes2 = deleteRes;
                } else {
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Failed: " + ((String) deleteRes.getSecond()), (Integer) null, 2, (Object) null);
                    this.$nameSwitch.setChecked(true);
                }
                return Unit.INSTANCE;
            case 2:
                deleteRes2 = (Pair) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
