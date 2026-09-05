package com.phisher98;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.phisher98.StreamPlay$Companion$getApiBase$4$workingProxy$1$deferredChecks$1$1 */
/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$Companion$getApiBase$4$workingProxy$1$deferredChecks$1$1", f = "StreamPlay.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class C0063x17c6b087 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $proxy;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0063x17c6b087(String str, Continuation<? super C0063x17c6b087> continuation) {
        super(2, continuation);
        this.$proxy = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0063x17c6b087(this.$proxy, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objCheckConnectivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objCheckConnectivity = StreamPlay.INSTANCE.checkConnectivity(this.$proxy, (Continuation) this);
                if (objCheckConnectivity == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objCheckConnectivity = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) objCheckConnectivity).booleanValue()) {
            return this.$proxy;
        }
        return null;
    }
}
