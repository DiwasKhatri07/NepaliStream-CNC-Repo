package com.layarKacaProvider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayarKacaProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LayarKacaProvider/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$Companion", f = "LayarKacaProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {51, 53}, m = "appGet", n = {"url", "headers", "referer", "allHeaders", "allowRedirects", "url", "headers", "referer", "allHeaders", "<unused var>", "allowRedirects"}, nl = {52, 50}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
final class LayarKacaProvider$Companion$appGet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LayarKacaProvider.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayarKacaProvider$Companion$appGet$1(LayarKacaProvider.Companion companion, Continuation<? super LayarKacaProvider$Companion$appGet$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.appGet(null, null, null, false, (Continuation) this);
    }
}
