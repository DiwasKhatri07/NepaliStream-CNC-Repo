package com.phisher98;

import android.view.LayoutInflater;
import android.view.View;
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
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaConfigureAppSettingsSync$show$2$1$5$1", f = "AppSettingsSync.kt", i = {1}, l = {148, 151}, m = "invokeSuspend", n = {"deleteRes"}, nl = {149, 152}, s = {"L$0"}, v = 2)
final class UltimaConfigureAppSettingsSync$show$2$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LayoutInflater $inflater;
    final /* synthetic */ View $settings;
    Object L$0;
    int label;
    final /* synthetic */ UltimaConfigureAppSettingsSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaConfigureAppSettingsSync$show$2$1$5$1(UltimaConfigureAppSettingsSync ultimaConfigureAppSettingsSync, View view, LayoutInflater layoutInflater, Continuation<? super UltimaConfigureAppSettingsSync$show$2$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaConfigureAppSettingsSync;
        this.$settings = view;
        this.$inflater = layoutInflater;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaConfigureAppSettingsSync$show$2$1$5$1(this.this$0, this.$settings, this.$inflater, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    /* JADX WARN: Code duplicated, block: B:16:0x0076 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x0077  */
    public final Object invokeSuspend(Object $result) {
        Object objDeregisterThisDevice;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objDeregisterThisDevice = UltimaSettingsSyncUtils.INSTANCE.deregisterThisDevice((Continuation) this);
                if (objDeregisterThisDevice == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Pair deleteRes = (Pair) objDeregisterThisDevice;
                this.this$0.sm.setAppSettingsSyncCreds(null);
                CommonActivity commonActivity = CommonActivity.INSTANCE;
                StringBuilder sbAppend = new StringBuilder().append("Sync credentials removed: ");
                str = (String) deleteRes.getSecond();
                if (str == null) {
                    str = "Reset successful";
                }
                CommonActivity.showToast$default(commonActivity, sbAppend.append(str).toString(), (Integer) null, 2, (Object) null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(deleteRes);
                this.label = 2;
                if (this.this$0.refreshDevicesList(this.$settings, this.$inflater, null, (Continuation) this) == coroutine_suspended) {
                    this.this$0.updateLastSyncInfo(this.$settings);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 1:
                ResultKt.throwOnFailure($result);
                objDeregisterThisDevice = $result;
                Pair deleteRes2 = (Pair) objDeregisterThisDevice;
                this.this$0.sm.setAppSettingsSyncCreds(null);
                CommonActivity commonActivity2 = CommonActivity.INSTANCE;
                StringBuilder sbAppend2 = new StringBuilder().append("Sync credentials removed: ");
                str = (String) deleteRes2.getSecond();
                if (str == null) {
                    str = "Reset successful";
                }
                CommonActivity.showToast$default(commonActivity2, sbAppend2.append(str).toString(), (Integer) null, 2, (Object) null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(deleteRes2);
                this.label = 2;
                if (this.this$0.refreshDevicesList(this.$settings, this.$inflater, null, (Continuation) this) == coroutine_suspended) {
                    this.this$0.updateLastSyncInfo(this.$settings);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 2:
                ResultKt.throwOnFailure($result);
                this.this$0.updateLastSyncInfo(this.$settings);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
