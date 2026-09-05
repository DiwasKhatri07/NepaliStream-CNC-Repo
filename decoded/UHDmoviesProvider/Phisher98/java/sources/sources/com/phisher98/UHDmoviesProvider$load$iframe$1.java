package com.phisher98;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: UHDmoviesProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/UHDmoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u00022\u000b\u0010\u0003\u001a\u00070\u0001¢\u0006\u0002\b\u0002H\n"}, d2 = {"<anonymous>", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;", "it"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UHDmoviesProvider$load$iframe$1", f = "UHDmoviesProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class UHDmoviesProvider$load$iframe$1 extends SuspendLambda implements Function2<Element, Continuation<? super Element>, Object> {
    /* synthetic */ Object L$0;
    int label;

    UHDmoviesProvider$load$iframe$1(Continuation<? super UHDmoviesProvider$load$iframe$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> uHDmoviesProvider$load$iframe$1 = new UHDmoviesProvider$load$iframe$1(continuation);
        uHDmoviesProvider$load$iframe$1.L$0 = obj;
        return uHDmoviesProvider$load$iframe$1;
    }

    public final Object invoke(Element element, Continuation<? super Element> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Element it = (Element) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
