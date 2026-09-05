package com.cncverse;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/TamilDhoolProvider/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00130\u0017H\u0096@¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003¨\u0006\u001e"}, d2 = {"Lcom/cncverse/Dailymotion;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "baseUrl", "videoIdRegex", "Lkotlin/text/Regex;", "getVideoIdRegex$annotations", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmbedUrl", "getVideoId", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/cncverse/Dailymotion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,233:1\n777#2:234\n873#2,2:235\n1915#2,2:237\n1915#2:239\n1916#2:242\n1342#3,2:240\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/cncverse/Dailymotion\n*L\n37#1:234\n37#1:235,2\n39#1:237,2\n49#1:239\n49#1:242\n51#1:240,2\n*E\n"})
public class Dailymotion extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String mainUrl = "https://www.dailymotion.com";

    @NotNull
    private final String name = "Dailymotion";

    @NotNull
    private final String baseUrl = "https://www.dailymotion.com";

    @NotNull
    private final Regex videoIdRegex = new Regex("^[kx][a-zA-Z0-9]+$");

    /* JADX INFO: renamed from: com.cncverse.Dailymotion$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.Dailymotion", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {31, 40}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "embedUrl", "id", "metaDataUrl", "$this", "url", "referer", "subtitleCallback", "callback", "embedUrl", "id", "metaDataUrl", "response", "qualityUrlRegex", "subtitlesRegex", "urls", "$this$forEach$iv", "element$iv", "videoUrl", "$i$f$forEach", "$i$a$-forEach-Dailymotion$getUrl$2"}, nl = {32, 46}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return Dailymotion.getUrl$suspendImpl(Dailymotion.this, null, null, null, null, (Continuation) this);
        }
    }

    private static /* synthetic */ void getVideoIdRegex$annotations() {
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x021c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0296 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0297  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0297 -> B:41:0x02ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at java.base/java.util.BitSet.get(BitSet.java:628)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:744)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.cncverse.Dailymotion r34, java.lang.String r35, java.lang.String r36, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r38, kotlin.coroutines.Continuation<? super kotlin.Unit> r39) {
        /*
            Method dump skipped, instruction units count: 882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.Dailymotion.getUrl$suspendImpl(com.cncverse.Dailymotion, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getUrl$lambda$0(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getUrl$lambda$3(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    private final String getEmbedUrl(String url) {
        if (StringsKt.contains$default(url, "/embed/", false, 2, (Object) null) || StringsKt.contains$default(url, "/video/", false, 2, (Object) null)) {
            return url;
        }
        if (!StringsKt.contains$default(url, "geo.dailymotion.com", false, 2, (Object) null)) {
            return null;
        }
        String videoId = StringsKt.substringAfter$default(url, "video=", (String) null, 2, (Object) null);
        return this.baseUrl + "/embed/video/" + videoId;
    }

    private final String getVideoId(String url) {
        String path = new URI(url).getPath();
        String id = StringsKt.substringAfter$default(path, "/video/", (String) null, 2, (Object) null);
        if (this.videoIdRegex.matches(id)) {
            return id;
        }
        return null;
    }
}
