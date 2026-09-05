package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor", f = "StreamPlayExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {4648, 4676}, m = "invokecinemacity$emitExtractorLinks", n = {"$callback", "pageUrl", "subtitleTracks", "files", "seasonNum", "episodeNum", "$callback", "pageUrl", "subtitleTracks", "files", "seasonNum", "episodeNum", "parts", "audioFiles", "$this$forEachIndexed$iv", "item$iv", "downloads", "$this$forEach$iv", "element$iv", "dlUrl", "lang", "index$iv", "index", "quality"}, nl = {4647, 4675}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "I$0", "I$1", "I$2"}, v = 2)
final class StreamPlayExtractor$invokecinemacity$emitExtractorLinks$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
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

    StreamPlayExtractor$invokecinemacity$emitExtractorLinks$1(Continuation<? super StreamPlayExtractor$invokecinemacity$emitExtractorLinks$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamPlayExtractor.invokecinemacity$emitExtractorLinks(null, null, null, null, null, null, (Continuation) this);
    }
}
