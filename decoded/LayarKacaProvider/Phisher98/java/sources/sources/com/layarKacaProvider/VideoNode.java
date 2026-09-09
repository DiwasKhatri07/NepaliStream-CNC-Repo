package com.layarKacaProvider;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LayarKacaProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002JH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0014H\u0096@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/layarKacaProvider/VideoNode;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "fixLocalUrl", "url", "getUrl", "", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/VideoNode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n2068#2,2:327\n2068#2:329\n2069#2:331\n2068#2:332\n2068#2,2:333\n2069#2:335\n2068#2,2:337\n2068#2:342\n2068#2,2:345\n2069#2:351\n1#3:330\n1505#4:336\n1506#4:339\n1505#4,2:340\n1505#4:343\n1505#4:344\n1506#4:347\n1505#4,2:348\n1506#4:350\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/VideoNode\n*L\n250#1:327,2\n274#1:329\n274#1:331\n285#1:332\n290#1:333,2\n285#1:335\n301#1:337,2\n312#1:342\n317#1:345,2\n312#1:351\n299#1:336\n299#1:339\n305#1:340,2\n314#1:343\n316#1:344\n316#1:347\n319#1:348,2\n314#1:350\n*E\n"})
public class VideoNode extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "VideoNode";

    @NotNull
    private final String mainUrl = "https://videonode.de";

    /* JADX INFO: renamed from: com.layarKacaProvider.VideoNode$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.VideoNode", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}, l = {191, 207, 230, 246, 252, 257, 258, 261, 262, 265, 266, 267, 278, 279, 280, 290, 292, 301, 307, 317, 320}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "$this$getUrl_u24lambda_u240", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$getUrl_u24lambda_u241", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "slug", "$this$getUrl_u24lambda_u243", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "slug", "verifyRes", "fileUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "slug", "verifyRes", "fileUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "apiRes", "embedUrl", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$forEach$iv", "element$iv", "iframe", "src", "rawSrc", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$forEach$iv", "element$iv", "iframe", "src", "rawSrc", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$forEach$iv", "element$iv", "iframe", "src", "rawSrc", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$forEach$iv", "element$iv", "source", "src", "resolvedSrc", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "$this$forEach$iv", "element$iv", "source", "src", "resolvedSrc", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "m3u8Regex", "$this$forEach$iv", "element$iv", "match", "m3u8Url", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "m3u8Regex", "mp4Regex", "$this$forEach$iv", "element$iv", "match", "mp4Url", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "m3u8Regex", "mp4Regex", "packedRegex", "$this$forEach$iv", "element$iv", "s", "data", "$this$forEach$iv", "element$iv", "match", "element$iv", "$this$forEach$iv", "unpacked", "m", "$this", "url", "referer", "subtitleCallback", "callback", "cleanUrl", "hostFromUrl", "idFromUrl", "pageRef", "response", "text", "doc", "host", "id", "m3u8Regex", "mp4Regex", "packedRegex", "$this$forEach$iv", "element$iv", "s", "data", "$this$forEach$iv", "element$iv", "match", "element$iv", "$this$forEach$iv", "unpacked", "m"}, nl = {190, 217, 237, 250, 256, 258, 260, 262, 265, 266, 267, 274, 279, 280, 282, 333, 295, 337, 308, 345, 321}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "L$27", "L$28", "L$29", "L$30", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "L$27", "L$28", "L$29", "L$30"}, v = 2)
    static final class C00121 extends ContinuationImpl {
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
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoNode.getUrl$suspendImpl(VideoNode.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    private final String fixLocalUrl(String url) {
        if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
            return "https:" + url;
        }
        return StringsKt.startsWith$default(url, "/", false, 2, (Object) null) ? getMainUrl() + url : url;
    }

    /* JADX WARN: Code duplicated, block: B:291:0x17a9  */
    /* JADX WARN: Code duplicated, block: B:293:0x17c1  */
    /* JADX WARN: Code duplicated, block: B:294:0x17cc  */
    /* JADX WARN: Code duplicated, block: B:297:0x17dc  */
    /* JADX WARN: Code duplicated, block: B:299:0x17ef  */
    /* JADX WARN: Code duplicated, block: B:315:0x198b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 88261. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:312:0x1966 -> B:313:0x196e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:338:0x1ae9 -> B:345:0x1be1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:342:0x1b88 -> B:343:0x1baa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:344:0x1bca -> B:345:0x1be1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:353:0x1cc5 -> B:354:0x1ce2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:365:0x1ddd -> B:366:0x1dfd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:374:0x1e5b -> B:375:0x1eae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:399:0x202d -> B:389:0x1f14). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:400:0x2053 -> B:401:0x20a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:406:0x218a -> B:407:0x21a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.layarKacaProvider.VideoNode r63, java.lang.String r64, java.lang.String r65, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r66, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r67, kotlin.coroutines.Continuation<? super kotlin.Unit> r68) {
        /*
            Method dump skipped, instruction units count: 8826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.layarKacaProvider.VideoNode.getUrl$suspendImpl(com.layarKacaProvider.VideoNode, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
