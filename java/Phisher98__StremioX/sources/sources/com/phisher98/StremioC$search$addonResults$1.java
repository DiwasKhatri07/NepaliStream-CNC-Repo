package com.phisher98;

import com.lagradost.cloudstream3.SearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "catalog", "Lcom/phisher98/StremioC$Catalog;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$search$addonResults$1", f = "StremioC.kt", i = {0}, l = {161}, m = "invokeSuspend", n = {"catalog"}, nl = {-1}, s = {"L$0"}, v = 2)
final class StremioC$search$addonResults$1 extends SuspendLambda implements Function2<StremioC.Catalog, Continuation<? super List<? extends SearchResponse>>, Object> {
    final /* synthetic */ String $query;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StremioC this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$search$addonResults$1(String str, StremioC stremioC, Continuation<? super StremioC$search$addonResults$1> continuation) {
        super(2, continuation);
        this.$query = str;
        this.this$0 = stremioC;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioC$search$addonResults$1 = new StremioC$search$addonResults$1(this.$query, this.this$0, continuation);
        stremioC$search$addonResults$1.L$0 = obj;
        return stremioC$search$addonResults$1;
    }

    public final Object invoke(StremioC.Catalog catalog, Continuation<? super List<? extends SearchResponse>> continuation) {
        return create(catalog, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        StremioC.Catalog catalog = (StremioC.Catalog) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(catalog);
                this.label = 1;
                Object objSearch = catalog.search(this.$query, this.this$0, (Continuation) this);
                return objSearch == coroutine_suspended ? coroutine_suspended : objSearch;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
