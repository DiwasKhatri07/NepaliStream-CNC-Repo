package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$CatalogEntry", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {456, 466, 500, 529}, m = "toLoadResponse", n = {"provider", "imdbId", "allTrailers", "fetchedRecommendations", "extractedImdbId", "extractedTmdbId", "finalImdbId", "tmdbIdStr", "tmdbMediaType", "findUrl", "isMovie", "provider", "imdbId", "allTrailers", "fetchedRecommendations", "extractedImdbId", "extractedTmdbId", "finalImdbId", "tmdbIdStr", "tmdbMediaType", "detailUrl", "isMovie", "provider", "imdbId", "allTrailers", "fetchedRecommendations", "extractedImdbId", "extractedTmdbId", "finalImdbId", "tmdbIdStr", "provider", "imdbId", "allTrailers", "fetchedRecommendations", "extractedImdbId", "extractedTmdbId", "finalImdbId", "tmdbIdStr"}, nl = {1083, 1088, 529, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
final class StremioC$CatalogEntry$toLoadResponse$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StremioC.CatalogEntry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$CatalogEntry$toLoadResponse$1(StremioC.CatalogEntry catalogEntry, Continuation<? super StremioC$CatalogEntry$toLoadResponse$1> continuation) {
        super(continuation);
        this.this$0 = catalogEntry;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.toLoadResponse(null, null, (Continuation) this);
    }
}
