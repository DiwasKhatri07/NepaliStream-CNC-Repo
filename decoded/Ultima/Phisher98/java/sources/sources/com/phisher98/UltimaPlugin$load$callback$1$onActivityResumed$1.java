package com.phisher98;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$load$callback$1$onActivityResumed$1", f = "UltimaPlugin.kt", i = {0}, l = {408}, m = "invokeSuspend", n = {"currentCreds"}, nl = {409}, s = {"L$0"}, v = 2)
final class UltimaPlugin$load$callback$1$onActivityResumed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    Object L$0;
    int label;
    final /* synthetic */ UltimaPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$load$callback$1$onActivityResumed$1(UltimaPlugin ultimaPlugin, Activity activity, Continuation<? super UltimaPlugin$load$callback$1$onActivityResumed$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaPlugin;
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$load$callback$1$onActivityResumed$1(this.this$0, this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AppSettingsSyncCreds currentCreds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                    if (currentCreds != null && currentCreds.isLoggedIn() && currentCreds.getRestoreDevice()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentCreds);
                        this.label = 1;
                        if (UltimaPlugin.pullChangedCategories$default(this.this$0, this.$activity, false, (Continuation) this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        UltimaPlugin.startSseListener$default(this.this$0, this.$activity, false, 2, null);
                        break;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    UltimaPlugin.startSseListener$default(this.this$0, this.$activity, false, 2, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
        }
    }
}
