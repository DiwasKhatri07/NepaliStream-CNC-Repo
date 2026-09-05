package com.cncverse;

import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PikashowProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PikashowProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.PikashowProvider$load$2$2", f = "PikashowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nPikashowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider$load$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1278:1\n1586#2:1279\n1661#2,3:1280\n*S KotlinDebug\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider$load$2$2\n*L\n533#1:1279\n533#1:1280,3\n*E\n"})
final class PikashowProvider$load$2$2 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ PikashowProvider.PikashowSeries $seriesData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PikashowProvider$load$2$2(PikashowProvider.PikashowSeries pikashowSeries, Continuation<? super PikashowProvider$load$2$2> continuation) {
        super(2, continuation);
        this.$seriesData = pikashowSeries;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pikashowProvider$load$2$2 = new PikashowProvider$load$2$2(this.$seriesData, continuation);
        pikashowProvider$load$2$2.L$0 = obj;
        return pikashowProvider$load$2$2;
    }

    public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
        return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ArrayList arrayList;
        Iterable iterableSplit$default;
        TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newTvSeriesLoadResponse.setPosterUrl(this.$seriesData.getCover());
                $this$newTvSeriesLoadResponse.setYear(this.$seriesData.getYear());
                $this$newTvSeriesLoadResponse.setPlot(this.$seriesData.getGenre());
                $this$newTvSeriesLoadResponse.setRecommendations(CollectionsKt.emptyList());
                String genre = this.$seriesData.getGenre();
                if (genre == null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    arrayList = null;
                } else {
                    Iterable $this$map$iv = iterableSplit$default;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(StringsKt.trim(it).toString());
                    }
                    arrayList = (List) destination$iv$iv;
                }
                $this$newTvSeriesLoadResponse.setTags(arrayList);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
