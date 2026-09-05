package com.cncverse;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LivXowPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LivXowProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.LivXowPlugin$load$categoryProviders$1", f = "LivXowPlugin.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class LivXowPlugin$load$categoryProviders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
    int label;

    LivXowPlugin$load$categoryProviders$1(Continuation<? super LivXowPlugin$load$categoryProviders$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LivXowPlugin$load$categoryProviders$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objFetchProviders = LivXowProviderManager.INSTANCE.fetchProviders((Continuation) this);
                if (objFetchProviders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchProviders;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
