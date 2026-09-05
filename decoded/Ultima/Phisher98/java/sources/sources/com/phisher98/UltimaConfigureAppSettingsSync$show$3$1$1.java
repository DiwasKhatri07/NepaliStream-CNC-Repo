package com.phisher98;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppSettingsSync.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaConfigureAppSettingsSync$show$3$1$1", f = "AppSettingsSync.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, nl = {174}, s = {}, v = 2)
final class UltimaConfigureAppSettingsSync$show$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $context;
    final /* synthetic */ View $settings;
    int label;
    final /* synthetic */ UltimaConfigureAppSettingsSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaConfigureAppSettingsSync$show$3$1$1(UltimaConfigureAppSettingsSync ultimaConfigureAppSettingsSync, AppCompatActivity appCompatActivity, View view, Continuation<? super UltimaConfigureAppSettingsSync$show$3$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaConfigureAppSettingsSync;
        this.$context = appCompatActivity;
        this.$settings = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaConfigureAppSettingsSync$show$3$1$1(this.this$0, this.$context, this.$settings, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Syncing all categories...", (Integer) null, 2, (Object) null);
                this.label = 1;
                if (this.this$0.getPlugin().mergeAndSyncAllCategories((Context) this.$context, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Sync complete!", (Integer) null, 2, (Object) null);
        this.this$0.updateLastSyncInfo(this.$settings);
        return Unit.INSTANCE;
    }
}
