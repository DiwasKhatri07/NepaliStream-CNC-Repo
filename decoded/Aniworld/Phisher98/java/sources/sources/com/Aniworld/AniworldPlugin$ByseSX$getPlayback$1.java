package com.Aniworld;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniworldPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Aniworld/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Aniworld.AniworldPlugin$ByseSX", f = "AniworldPlugin.kt", i = {0, 1, 1, 1, 1, 1, 1, 1}, l = {66, 80}, m = "getPlayback", n = {"mainUrl", "mainUrl", "details", "embedFrameUrl", "embedBase", "code", "playbackUrl", "headers"}, nl = {67, 83}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
final class AniworldPlugin$ByseSX$getPlayback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AniworldPlugin.ByseSX this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AniworldPlugin$ByseSX$getPlayback$1(AniworldPlugin.ByseSX byseSX, Continuation<? super AniworldPlugin$ByseSX$getPlayback$1> continuation) {
        super(continuation);
        this.this$0 = byseSX;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPlayback(null, (Continuation) this);
    }
}
