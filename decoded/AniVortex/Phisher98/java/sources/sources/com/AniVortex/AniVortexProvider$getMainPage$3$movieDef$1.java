package com.AniVortex;

import com.lagradost.cloudstream3.HomePageList;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.AniVortex.AniVortexProvider$getMainPage$3$movieDef$1", f = "AniVortexProvider.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class AniVortexProvider$getMainPage$3$movieDef$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HomePageList>>, Object> {
    int label;
    final /* synthetic */ AniVortexProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AniVortexProvider$getMainPage$3$movieDef$1(AniVortexProvider aniVortexProvider, Continuation<? super AniVortexProvider$getMainPage$3$movieDef$1> continuation) {
        super(2, continuation);
        this.this$0 = aniVortexProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AniVortexProvider$getMainPage$3$movieDef$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<HomePageList>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objFetchCatalogHome = this.this$0.fetchCatalogHome("movie_series", (Continuation) this);
                return objFetchCatalogHome == coroutine_suspended ? coroutine_suspended : objFetchCatalogHome;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
