package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1", f = "StreamPlayStremioAddon.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,239:1\n651#2,7:240\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1\n*L\n167#1:240,7\n*E\n"})
final class StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $proxyReq;
    final /* synthetic */ Map<String, String> $stdHeaders;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1(String str, Map<String, String> map, Map<String, String> map2, Continuation<? super StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1> continuation) {
        super(2, continuation);
        this.$title = str;
        this.$proxyReq = map;
        this.$stdHeaders = map2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1 = new StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1(this.$title, this.$proxyReq, this.$stdHeaders, continuation);
        streamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1.L$0 = obj;
        return streamPlayStremioAddonKt$invokeStreamioStreamsGlobal$2$1;
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
                $this$newExtractorLink.setQuality(StreamPlayUtilsKt.getIndexQuality(this.$title));
                Pair[] pairArr = new Pair[3];
                String header = StreamPlayStremioAddonKt.getHeader(this.$proxyReq, "User-Agent");
                if (header == null && (header = StreamPlayStremioAddonKt.getHeader(this.$stdHeaders, "User-Agent")) == null) {
                    header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36";
                }
                pairArr[0] = TuplesKt.to("User-Agent", header);
                String header2 = StreamPlayStremioAddonKt.getHeader(this.$proxyReq, "Referer");
                if (header2 == null && (header2 = StreamPlayStremioAddonKt.getHeader(this.$stdHeaders, "Referer")) == null) {
                    header2 = "";
                }
                pairArr[1] = TuplesKt.to("Referer", header2);
                String header3 = StreamPlayStremioAddonKt.getHeader(this.$proxyReq, "Origin");
                pairArr[2] = TuplesKt.to("Origin", (header3 == null && (header3 = StreamPlayStremioAddonKt.getHeader(this.$stdHeaders, "Origin")) == null) ? "" : header3);
                Map $this$filterValues$iv = MapsKt.mapOf(pairArr);
                LinkedHashMap result$iv = new LinkedHashMap();
                for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                    String it = (String) entry$iv.getValue();
                    if (!StringsKt.isBlank(it)) {
                        result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                    }
                }
                LinkedHashMap $this$filterValues$iv2 = result$iv;
                $this$newExtractorLink.setHeaders($this$filterValues$iv2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
