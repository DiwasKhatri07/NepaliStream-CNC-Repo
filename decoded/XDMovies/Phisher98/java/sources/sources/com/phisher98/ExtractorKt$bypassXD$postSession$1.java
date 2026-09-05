package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/XDMovies/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ExtractorKt", f = "Extractor.kt", i = {0, 0, 0, 0, 0}, l = {467}, m = "bypassXD$postSession", n = {"code", "baseUrl", "fingerprint", "isolatedApp", "baseHeaders"}, nl = {471}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
final class ExtractorKt$bypassXD$postSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    ExtractorKt$bypassXD$postSession$1(Continuation<? super ExtractorKt$bypassXD$postSession$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExtractorKt.bypassXD$postSession(null, null, null, null, null, (Continuation) this);
    }
}
