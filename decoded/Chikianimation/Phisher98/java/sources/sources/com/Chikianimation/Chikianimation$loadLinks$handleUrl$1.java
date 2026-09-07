package com.Chikianimation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Chikianimation.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Chikianimation/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Chikianimation.Chikianimation", f = "Chikianimation.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {234, 244, 252}, m = "loadLinks$handleUrl", n = {"this$0", "$subtitleCallback", "$callback", "found", "url", "ref", "cleanUrl", "dmMatch", "videoId", "$this$loadLinks_u24handleUrl_u24lambda_u241", "this$0", "$subtitleCallback", "$callback", "found", "url", "ref", "cleanUrl", "dmMatch", "$this$loadLinks_u24handleUrl_u24lambda_u242", "this$0", "$subtitleCallback", "$callback", "found", "url", "ref", "cleanUrl", "dmMatch", "$this$loadLinks_u24handleUrl_u24lambda_u243"}, nl = {235, 245, 253}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
final class Chikianimation$loadLinks$handleUrl$1 extends ContinuationImpl {
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

    Chikianimation$loadLinks$handleUrl$1(Continuation<? super Chikianimation$loadLinks$handleUrl$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Chikianimation.loadLinks$handleUrl(null, null, null, null, null, null, (Continuation) this);
    }
}
