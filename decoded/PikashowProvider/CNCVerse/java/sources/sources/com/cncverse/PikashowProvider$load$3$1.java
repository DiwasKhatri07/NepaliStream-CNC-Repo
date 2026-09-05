package com.cncverse;

import com.lagradost.cloudstream3.MovieLoadResponse;
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
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PikashowProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.PikashowProvider$load$3$1", f = "PikashowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nPikashowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider$load$3$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1278:1\n1586#2:1279\n1661#2,3:1280\n*S KotlinDebug\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider$load$3$1\n*L\n568#1:1279\n568#1:1280,3\n*E\n"})
final class PikashowProvider$load$3$1 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ PikashowProvider.PikashowMovie $movieData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PikashowProvider$load$3$1(PikashowProvider.PikashowMovie pikashowMovie, Continuation<? super PikashowProvider$load$3$1> continuation) {
        super(2, continuation);
        this.$movieData = pikashowMovie;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pikashowProvider$load$3$1 = new PikashowProvider$load$3$1(this.$movieData, continuation);
        pikashowProvider$load$3$1.L$0 = obj;
        return pikashowProvider$load$3$1;
    }

    public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
        return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ArrayList arrayList;
        Iterable iterableSplit$default;
        MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newMovieLoadResponse.setPosterUrl(this.$movieData.getCover());
                $this$newMovieLoadResponse.setYear(this.$movieData.getYear());
                $this$newMovieLoadResponse.setPlot(this.$movieData.getGenre());
                String genre = this.$movieData.getGenre();
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
                $this$newMovieLoadResponse.setTags(arrayList);
                $this$newMovieLoadResponse.setRecommendations(CollectionsKt.emptyList());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
