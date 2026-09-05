package com.Netcinez;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Netcinez.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Netcinez/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/TvSeriesSearchResponse;", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Netcinez.Netcinez$load$recommendations$1", f = "Netcinez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class Netcinez$load$recommendations$1 extends SuspendLambda implements Function2<Element, Continuation<? super TvSeriesSearchResponse>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Netcinez this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Netcinez$load$recommendations$1(Netcinez netcinez, Continuation<? super Netcinez$load$recommendations$1> continuation) {
        super(2, continuation);
        this.this$0 = netcinez;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netcinez$load$recommendations$1 = new Netcinez$load$recommendations$1(this.this$0, continuation);
        netcinez$load$recommendations$1.L$0 = obj;
        return netcinez$load$recommendations$1;
    }

    public final Object invoke(Element element, Continuation<? super TvSeriesSearchResponse> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Element it = (Element) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String recName = it.select("div.data-r > h4").text();
                String recHref = it.attr("href");
                final String recPosterUrl = it.select("img").attr("src");
                return MainAPIKt.newTvSeriesSearchResponse$default(this.this$0, recName, recHref, TvType.Movie, false, new Function1() { // from class: com.Netcinez.Netcinez$load$recommendations$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return Netcinez$load$recommendations$1.invokeSuspend$lambda$0(recPosterUrl, (TvSeriesSearchResponse) obj);
                    }
                }, 8, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit invokeSuspend$lambda$0(String $recPosterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($recPosterUrl);
        return Unit.INSTANCE;
    }
}
