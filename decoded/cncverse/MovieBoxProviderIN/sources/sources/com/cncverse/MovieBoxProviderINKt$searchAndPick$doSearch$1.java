package com.cncverse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBoxProviderIN.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/MovieBoxProviderIN/classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.MovieBoxProviderINKt", f = "MovieBoxProviderIN.kt", i = {0, 0, 0}, l = {1207}, m = "searchAndPick$doSearch", n = {"endpoint", "extraParams", "url"}, nl = {1208}, s = {"L$0", "L$1", "L$2"}, v = 2)
final class MovieBoxProviderINKt$searchAndPick$doSearch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MovieBoxProviderINKt$searchAndPick$doSearch$1(Continuation<? super MovieBoxProviderINKt$searchAndPick$doSearch$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MovieBoxProviderINKt.searchAndPick$doSearch(null, null, (Continuation) this);
    }
}
