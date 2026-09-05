package com.phisher98;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.Score;
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

/* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2", f = "StreamPlayStremioCatelog.kt", i = {0}, l = {308}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {309}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayStremioCatelog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,451:1\n1739#2:452\n1814#2,3:453\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2\n*L\n308#1:452\n308#1:453,3\n*E\n"})
final class StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imdbId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StreamPlayStremioCatelog.CatalogEntry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2(StreamPlayStremioCatelog.CatalogEntry catalogEntry, String str, Continuation<? super StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2> continuation) {
        super(2, continuation);
        this.this$0 = catalogEntry;
        this.$imdbId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayStremioCatelog$CatalogEntry$toLoadResponse$2 = new StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2(this.this$0, this.$imdbId, continuation);
        streamPlayStremioCatelog$CatalogEntry$toLoadResponse$2.L$0 = obj;
        return streamPlayStremioCatelog$CatalogEntry$toLoadResponse$2;
    }

    public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
        return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                loadResponse.setPosterUrl(this.this$0.getPoster());
                loadResponse.setBackgroundPosterUrl(this.this$0.getBackground());
                loadResponse.setScore(Score.Companion.from10(this.this$0.getImdbRating()));
                loadResponse.setPlot(this.this$0.getDescription());
                String yearNum = this.this$0.getYearNum();
                loadResponse.setYear(yearNum != null ? StringsKt.toIntOrNull(yearNum) : null);
                List<String> genre = this.this$0.getGenre();
                if (genre == null) {
                    genre = this.this$0.getGenres();
                }
                loadResponse.setTags(genre);
                LoadResponse.Companion.addActorNames(loadResponse, this.this$0.getCast());
                LoadResponse.Companion companion = LoadResponse.Companion;
                LoadResponse loadResponse2 = loadResponse;
                Iterable $this$map$iv = this.this$0.getTrailersSources();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    StreamPlayStremioCatelog.Trailer it = (StreamPlayStremioCatelog.Trailer) item$iv$iv;
                    destination$iv$iv.add("https://www.youtube.com/watch?v=" + it.getSource());
                }
                this.L$0 = loadResponse;
                this.label = 1;
                if (LoadResponse.Companion.addTrailer$default(companion, loadResponse2, (List) destination$iv$iv, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
        return Unit.INSTANCE;
    }
}
