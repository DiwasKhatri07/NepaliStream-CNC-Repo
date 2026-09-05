package com.Kartoons;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Kartoons.Kartoons$loadLinks$2$1", f = "Kartoons.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class Kartoons$loadLinks$2$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    Kartoons$loadLinks$2$1(Continuation<? super Kartoons$loadLinks$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kartoons$loadLinks$2$1 = new Kartoons$loadLinks$2$1(continuation);
        kartoons$loadLinks$2$1.L$0 = obj;
        return kartoons$loadLinks$2$1;
    }

    public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
        return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newExtractorLink.setReferer("https://kartoons.me/");
                $this$newExtractorLink.setHeaders(MapsKt.plus(MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("Origin", "https://kartoons.me"), TuplesKt.to("Accept", "*/*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Sec-Fetch-Dest", "empty"), TuplesKt.to("Sec-Fetch-Mode", "cors"), TuplesKt.to("Sec-Fetch-Site", "cross-site")}), MapsKt.mapOf(TuplesKt.to("User-Agent", KartoonsPlugin.INSTANCE.getCfUserAgent().length() > 0 ? KartoonsPlugin.INSTANCE.getCfUserAgent() : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"))), KartoonsPlugin.INSTANCE.getCfCookies().length() > 0 ? MapsKt.mapOf(TuplesKt.to("Cookie", KartoonsPlugin.INSTANCE.getCfCookies())) : MapsKt.emptyMap()));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
