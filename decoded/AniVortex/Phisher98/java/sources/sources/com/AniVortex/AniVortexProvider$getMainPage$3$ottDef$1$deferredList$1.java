package com.AniVortex;

import com.lagradost.cloudstream3.HomePageList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AniVortexProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.AniVortex.AniVortexProvider$getMainPage$3$ottDef$1$deferredList$1", f = "AniVortexProvider.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class AniVortexProvider$getMainPage$3$ottDef$1$deferredList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HomePageList>, Object> {
    int label;
    final /* synthetic */ AniVortexProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AniVortexProvider$getMainPage$3$ottDef$1$deferredList$1(AniVortexProvider aniVortexProvider, Continuation<? super AniVortexProvider$getMainPage$3$ottDef$1$deferredList$1> continuation) {
        super(2, continuation);
        this.this$0 = aniVortexProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AniVortexProvider$getMainPage$3$ottDef$1$deferredList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HomePageList> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objFetchOttSection = this.this$0.fetchOttSection("netflix", "Popular on Netflix", (Continuation) this);
                return objFetchOttSection == coroutine_suspended ? coroutine_suspended : objFetchOttSection;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
