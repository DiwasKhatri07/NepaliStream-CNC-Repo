package com.cncverse;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MLSBDProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/cncverse/Filesdl;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MLSBDProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/cncverse/Filesdl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,606:1\n1586#2:607\n1661#2,3:608\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/cncverse/Filesdl\n*L\n40#1:607\n40#1:608,3\n*E\n"})
public final class Filesdl extends ExtractorApi {

    @NotNull
    private final String name = "Filesdl";

    @NotNull
    private final String mainUrl = "https://new6.filesdl.site";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.cncverse.Filesdl$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.Filesdl", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {36, 45, 47, 49, 52, 55, 68}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "response", "redirectUrl", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "source", "href", "$i$f$map", "$i$f$mapTo", "$i$a$-map-Filesdl$getUrl$2"}, nl = {37, 47, 49, 51, 53, 54, 67}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
        Object L$18;
        Object L$19;
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Filesdl.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0426  */
    /* JADX WARN: Code duplicated, block: B:33:0x0455  */
    /* JADX WARN: Code duplicated, block: B:35:0x04d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:38:0x0504  */
    /* JADX WARN: Code duplicated, block: B:40:0x051e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0594 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0595  */
    /* JADX WARN: Code duplicated, block: B:45:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x064e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x064f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0686  */
    /* JADX WARN: Code duplicated, block: B:54:0x0697  */
    /* JADX WARN: Code duplicated, block: B:67:0x07ad A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:70:0x0837 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0838  */
    /* JADX WARN: Code duplicated, block: B:74:0x0867  */
    /* JADX WARN: Code duplicated, block: B:75:0x086a  */
    /* JADX WARN: Code duplicated, block: B:78:0x08f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x08f1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x074c -> B:65:0x0766). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x078d -> B:81:0x0921). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x051e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r47, @org.jetbrains.annotations.Nullable java.lang.String r48, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r49, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r50, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r51) {
        /*
            Method dump skipped, instruction units count: 2394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.Filesdl.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
