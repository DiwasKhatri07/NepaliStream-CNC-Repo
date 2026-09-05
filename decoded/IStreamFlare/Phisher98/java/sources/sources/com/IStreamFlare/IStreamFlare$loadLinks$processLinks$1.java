package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlare.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {442, 457, 466, 479}, m = "loadLinks$processLinks", n = {"$callback", "this$0", "$subtitleCallback", "links", "$this$forEach$iv", "element$iv", "link", "$callback", "this$0", "$subtitleCallback", "links", "$this$forEach$iv", "element$iv", "link", "linkFound", "extractor", "$callback", "this$0", "$subtitleCallback", "links", "$this$forEach$iv", "element$iv", "link", "linkFound", "extractor", "$callback", "this$0", "$subtitleCallback", "links", "$this$forEach$iv", "element$iv", "link", "type"}, nl = {441, 465, 476, 478}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$9"}, v = 2)
final class IStreamFlare$loadLinks$processLinks$1 extends ContinuationImpl {
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

    IStreamFlare$loadLinks$processLinks$1(Continuation<? super IStreamFlare$loadLinks$processLinks$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IStreamFlare.loadLinks$processLinks(null, null, null, null, (Continuation) this);
    }
}
