package com.phisher98;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
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
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$CatalogEntry$toLoadResponse$6", f = "StremioC.kt", i = {0}, l = {544}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {546}, s = {"L$0"}, v = 2)
final class StremioC$CatalogEntry$toLoadResponse$6 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $allTrailers;
    final /* synthetic */ Ref.ObjectRef<List<SearchResponse>> $fetchedRecommendations;
    final /* synthetic */ String $finalImdbId;
    final /* synthetic */ Ref.ObjectRef<String> $tmdbIdStr;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StremioC.CatalogEntry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$CatalogEntry$toLoadResponse$6(StremioC.CatalogEntry catalogEntry, List<String> list, Ref.ObjectRef<List<SearchResponse>> objectRef, Ref.ObjectRef<String> objectRef2, String str, Continuation<? super StremioC$CatalogEntry$toLoadResponse$6> continuation) {
        super(2, continuation);
        this.this$0 = catalogEntry;
        this.$allTrailers = list;
        this.$fetchedRecommendations = objectRef;
        this.$tmdbIdStr = objectRef2;
        this.$finalImdbId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioC$CatalogEntry$toLoadResponse$6 = new StremioC$CatalogEntry$toLoadResponse$6(this.this$0, this.$allTrailers, this.$fetchedRecommendations, this.$tmdbIdStr, this.$finalImdbId, continuation);
        stremioC$CatalogEntry$toLoadResponse$6.L$0 = obj;
        return stremioC$CatalogEntry$toLoadResponse$6;
    }

    public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
        return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
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
                this.L$0 = loadResponse;
                this.label = 1;
                if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, (String) CollectionsKt.randomOrNull(this.$allTrailers, Random.Default), (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        loadResponse.setRecommendations((List) this.$fetchedRecommendations.element);
        String it = (String) this.$tmdbIdStr.element;
        if (it != null) {
            LoadResponse.Companion.addTMDbId(loadResponse, it);
        }
        String it2 = this.$finalImdbId;
        if (it2 != null) {
            if (StringsKt.startsWith$default(it2, "tt", false, 2, (Object) null)) {
                LoadResponse.Companion.addImdbId(loadResponse, it2);
            } else {
                System.out.println((Object) ("Kitsu or TMDB ID: " + it2));
            }
        }
        return Unit.INSTANCE;
    }
}
