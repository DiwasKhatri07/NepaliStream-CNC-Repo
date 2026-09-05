package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.net.URI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OnePace/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "OnePace"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,393:1\n1#2:394\n2068#3,2:395\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n*L\n202#1:395,2\n*E\n"})
public final class GDMirrorbot extends ExtractorApi {

    @NotNull
    private String name = "GDMirrorbot";

    @NotNull
    private String mainUrl = "https://gdmirrorbot.nl";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.GDMirrorbot$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {146, 148, 163, 181, 211, 212, 213}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "pageText", "finalId", "myKey", "idType", "baseUrl", "hostUrl", "apiUrl", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base"}, nl = {148, 149, 166, 183, 212, 213, 215}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDMirrorbot.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0771  */
    /* JADX WARN: Code duplicated, block: B:167:0x0781  */
    /* JADX WARN: Code duplicated, block: B:214:0x087a  */
    /* JADX WARN: Code duplicated, block: B:215:0x0887 A[Catch: Exception -> 0x0a9c, TRY_LEAVE, TryCatch #3 {Exception -> 0x0a9c, blocks: (B:195:0x081f, B:197:0x0824, B:215:0x0887, B:212:0x0872), top: B:273:0x081f }] */
    /* JADX WARN: Code duplicated, block: B:219:0x08fa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:220:0x08fb  */
    /* JADX WARN: Code duplicated, block: B:227:0x09a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:228:0x09a6  */
    /* JADX WARN: Code duplicated, block: B:230:0x09d3  */
    /* JADX WARN: Code duplicated, block: B:233:0x09e5  */
    /* JADX WARN: Code duplicated, block: B:236:0x0a49 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:237:0x0a4a  */
    /* JADX WARN: Code duplicated, block: B:255:0x0bac  */
    /* JADX WARN: Code duplicated, block: B:283:0x09e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01f9: MOVE (r23 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('siteFriendlyNames' com.google.gson.JsonObject)]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0209: MOVE (r0 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('fullUrl' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x01fd: MOVE (r24 I:??[OBJECT, ARRAY] A[D('siteUrls' com.google.gson.JsonObject)]) = (r13 I:??[OBJECT, ARRAY] A[D('path' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0201: MOVE (r25 I:??[OBJECT, ARRAY] A[D('root' com.google.gson.JsonObject)]) = (r14 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0218: MOVE (r1 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x021c: MOVE (r5 I:??[OBJECT, ARRAY] A[D('referer' java.lang.String)]) = (r19 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x01f1: MOVE (r36 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0213: MOVE (r10 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('decodedMresult' com.google.gson.JsonObject)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x01f7: MOVE (r36 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY] A[D('siteFriendlyNames' com.google.gson.JsonObject)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x01fb: MOVE (r11 I:??[OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]) = (r24 I:??[OBJECT, ARRAY] A[D('siteUrls' com.google.gson.JsonObject)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x01ff: MOVE (r13 I:??[OBJECT, ARRAY] A[D('path' java.lang.String)]) = (r25 I:??[OBJECT, ARRAY] A[D('root' com.google.gson.JsonObject)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0219: MOVE (r15 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]) = (r26 I:??[OBJECT, ARRAY] A[D('rootElement' com.google.gson.JsonElement)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x020a: MOVE (r17 I:??[OBJECT, ARRAY]) = (r28 I:??[OBJECT, ARRAY] A[D('postData' java.util.Map)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x020c: MOVE (r16 I:??[OBJECT, ARRAY]) = (r29 I:??[OBJECT, ARRAY] A[D('host' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x021e: MOVE (r19 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]) = (r30 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]), block:B:22:0x01f1 */
    /* JADX WARN: Type inference failed for: r0v164 */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r1v83 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:237:0x0a4a -> B:238:0x0a6f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x0b3c -> B:253:0x0b8a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:256:0x0bb9 -> B:257:0x0bc2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.String r37, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 3104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.GDMirrorbot.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
