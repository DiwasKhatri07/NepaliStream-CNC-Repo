package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.jdk8.RegexExtensionsJDK8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0097@b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u00104¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/phisher98/UqloadsXyz;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/annotation/RequiresApi;", "value", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/UqloadsXyz\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2:4004\n2068#2,2:4005\n2069#2:4007\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/UqloadsXyz\n*L\n2074#1:4004\n2079#1:4005,2\n2074#1:4007\n*E\n"})
public final class UqloadsXyz extends ExtractorApi {

    @NotNull
    private final String name = "Uqloadsxyz";

    @NotNull
    private final String mainUrl = "https://uqloads.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.UqloadsXyz$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UqloadsXyz", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2047, 2050, 2075}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "response", "iframe", "url", "referer", "subtitleCallback", "callback", "response", "iframe", "script", "regex", "links", "$this$forEach$iv", "element$iv", "m3u8"}, nl = {2048, 2058, 2079}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12"}, v = 2)
    static final class C03041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C03041(Continuation<? super C03041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UqloadsXyz.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:47:0x026d  */
    /* JADX WARN: Code duplicated, block: B:49:0x02d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:54:0x02ee A[LOOP:0: B:52:0x02e8->B:54:0x02ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x02d8 -> B:51:0x02e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r33, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r34) {
        /*
            Method dump skipped, instruction units count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.UqloadsXyz.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final String getUrl$lambda$0(MatchResult matchResult) {
        MatchGroup matchGroup = RegexExtensionsJDK8Kt.get(matchResult.getGroups(), "hls2");
        String hls2 = matchGroup != null ? matchGroup.getValue() : null;
        MatchGroup matchGroup2 = RegexExtensionsJDK8Kt.get(matchResult.getGroups(), "hls4");
        String hls4 = matchGroup2 != null ? matchGroup2.getValue() : null;
        if (hls2 != null) {
            return hls2;
        }
        if (hls4 != null) {
            return "https://uqloads.xyz" + hls4;
        }
        return null;
    }
}
