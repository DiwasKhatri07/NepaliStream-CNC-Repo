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

/* JADX INFO: compiled from: MultiMoviesProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MultiMoviesProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.MultiMoviesProvider$mainUrl$1", f = "MultiMoviesProvider.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class MultiMoviesProvider$mainUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    MultiMoviesProvider$mainUrl$1(Continuation<? super MultiMoviesProvider$mainUrl$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiMoviesProvider$mainUrl$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object domains$default;
        String multiMovies;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                domains$default = MultiMoviesProviderPlugin.Companion.getDomains$default(MultiMoviesProviderPlugin.INSTANCE, false, (Continuation) this, 1, null);
                if (domains$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                domains$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MultiMoviesProviderPlugin.Companion.Domains domains = (MultiMoviesProviderPlugin.Companion.Domains) domains$default;
        return (domains == null || (multiMovies = domains.getMultiMovies()) == null) ? "https://multimovies.autos" : multiMovies;
    }
}
