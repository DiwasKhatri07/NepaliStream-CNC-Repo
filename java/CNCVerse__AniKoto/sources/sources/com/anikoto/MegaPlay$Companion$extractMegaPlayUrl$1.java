package com.anikoto;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnikotoExtractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/AniKoto/classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.anikoto.MegaPlay$Companion", f = "AnikotoExtractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {61, 79, 100, 105, 119}, m = "extractMegaPlayUrl", n = {"url", "referer", "host", "serverName", "subtitleCallback", "callback", "playbackHeaders", "pageHeaders", "url", "referer", "host", "serverName", "subtitleCallback", "callback", "playbackHeaders", "pageHeaders", "doc", "playerEl", "streamId", "type", "ajaxHeaders", "url", "referer", "host", "serverName", "subtitleCallback", "callback", "playbackHeaders", "pageHeaders", "doc", "playerEl", "streamId", "type", "ajaxHeaders", "jsonText", "root", "m3u8", "url", "referer", "host", "serverName", "subtitleCallback", "callback", "playbackHeaders", "pageHeaders", "doc", "playerEl", "streamId", "type", "ajaxHeaders", "jsonText", "root", "m3u8", "generated", "url", "referer", "host", "serverName", "subtitleCallback", "callback", "playbackHeaders", "pageHeaders", "doc", "playerEl", "streamId", "type", "ajaxHeaders", "jsonText", "root", "m3u8", "generated", "$this$forEach$iv", "element$iv", "track", "file", "kind", "label", "$i$f$forEach", "$i$a$-forEach-MegaPlay$Companion$extractMegaPlayUrl$3"}, nl = {62, 83, 101, 104, 118}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "I$1"}, v = 2)
final class MegaPlay$Companion$extractMegaPlayUrl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
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
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$22;
    Object L$23;
    Object L$24;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MegaPlay.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MegaPlay$Companion$extractMegaPlayUrl$1(MegaPlay.Companion companion, Continuation<? super MegaPlay$Companion$extractMegaPlayUrl$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.extractMegaPlayUrl(null, null, null, null, null, null, (Continuation) this);
    }
}
