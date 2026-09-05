package com.phisher98;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: UHDmoviesProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/UHDmoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/UHDmoviesProvider$UHDLinks;", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UHDmoviesProvider$load$data$2", f = "UHDmoviesProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class UHDmoviesProvider$load$data$2 extends SuspendLambda implements Function2<Element, Continuation<? super UHDmoviesProvider.UHDLinks>, Object> {
    /* synthetic */ Object L$0;
    int label;

    UHDmoviesProvider$load$data$2(Continuation<? super UHDmoviesProvider$load$data$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> uHDmoviesProvider$load$data$2 = new UHDmoviesProvider$load$data$2(continuation);
        uHDmoviesProvider$load$data$2.L$0 = obj;
        return uHDmoviesProvider$load$data$2;
    }

    public final Object invoke(Element element, Continuation<? super UHDmoviesProvider.UHDLinks> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String strAttr;
        Elements elementsSelect;
        Element it = (Element) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String strSubstringBefore$default = StringsKt.substringBefore$default(it.text(), "Download", (String) null, 2, (Object) null);
                Element elementNextElementSibling = it.nextElementSibling();
                if (elementNextElementSibling == null || (elementsSelect = elementNextElementSibling.select("a.maxbutton-1")) == null || (strAttr = elementsSelect.attr("href")) == null) {
                    strAttr = "";
                }
                return new UHDmoviesProvider.UHDLinks(strSubstringBefore$default, strAttr);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
