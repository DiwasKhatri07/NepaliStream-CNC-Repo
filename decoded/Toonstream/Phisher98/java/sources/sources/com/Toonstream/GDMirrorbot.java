package com.Toonstream;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Toonstream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/Toonstream/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/Toonstream/GDMirrorbot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,257:1\n1#2:258\n2068#3,2:259\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/Toonstream/GDMirrorbot\n*L\n103#1:259,2\n*E\n"})
public class GDMirrorbot extends ExtractorApi {

    @NotNull
    private String name = "GDMirrorbot";

    @NotNull
    private String mainUrl = "https://gdmirrorbot.nl";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Toonstream.GDMirrorbot$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.GDMirrorbot", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {47, 49, 64, 82, 111, 112, 113}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "pageText", "finalId", "myKey", "idType", "baseUrl", "hostUrl", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "rootElement", "root", "siteUrls", "siteFriendlyNames", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base"}, nl = {49, 50, 67, 84, 112, 113, 115}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDMirrorbot.getUrl$suspendImpl(GDMirrorbot.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:164:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:166:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:209:0x08c2 A[PHI: r9 r29
      0x08c2: PHI (r9v19 java.lang.String) = (r9v10 java.lang.String), (r9v11 java.lang.String), (r9v15 java.lang.String), (r9v20 java.lang.String) binds: [B:208:0x08c0, B:202:0x08a1, B:200:0x0896, B:194:0x086a] A[DONT_GENERATE, DONT_INLINE]
      0x08c2: PHI (r29v13 java.lang.String) = (r29v8 java.lang.String), (r29v9 java.lang.String), (r29v11 java.lang.String), (r29v14 java.lang.String) binds: [B:208:0x08c0, B:202:0x08a1, B:200:0x0896, B:194:0x086a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:215:0x0946 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:216:0x0947  */
    /* JADX WARN: Code duplicated, block: B:228:0x0a0d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:229:0x0a0e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0a68  */
    /* JADX WARN: Code duplicated, block: B:241:0x0a89  */
    /* JADX WARN: Code duplicated, block: B:246:0x0af1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:247:0x0af2  */
    /* JADX WARN: Code duplicated, block: B:256:0x0bc5  */
    /* JADX WARN: Code duplicated, block: B:271:0x08ca A[EXC_TOP_SPLITTER, PHI: r9 r29
      0x08ca: PHI (r9v12 java.lang.String) = (r9v10 java.lang.String), (r9v11 java.lang.String), (r9v15 java.lang.String) binds: [B:208:0x08c0, B:202:0x08a1, B:199:0x0894] A[DONT_GENERATE, DONT_INLINE]
      0x08ca: PHI (r29v10 java.lang.String) = (r29v8 java.lang.String), (r29v9 java.lang.String), (r29v11 java.lang.String) binds: [B:208:0x08c0, B:202:0x08a1, B:199:0x0894] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x0a74 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0229: MOVE (r23 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('siteFriendlyNames' com.google.gson.JsonObject)]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0225: MOVE (r19 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]) = (r14 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x020d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x021e: MOVE (r29 I:??[OBJECT, ARRAY] A[D('host' java.lang.String)]) = (r18 I:??[OBJECT, ARRAY] A[D('key' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0223: MOVE (r5 I:??[OBJECT, ARRAY] A[D('$this' com.Toonstream.GDMirrorbot)]) = (r19 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0205: MOVE (r6 I:??[OBJECT, ARRAY] A[D('$continuation' kotlin.coroutines.Continuation)]) = (r20 I:??[OBJECT, ARRAY]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x0230: MOVE (r25 I:??[OBJECT, ARRAY] A[D('root' com.google.gson.JsonObject)]) = (r21 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x022c: MOVE (r8 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('decodedMresult' com.google.gson.JsonObject)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0227: MOVE (r14 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]) = (r23 I:??[OBJECT, ARRAY] A[D('siteFriendlyNames' com.google.gson.JsonObject)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x020e: MOVE (r10 I:??[OBJECT, ARRAY]) = (r24 I:??[OBJECT, ARRAY] A[D('siteUrls' com.google.gson.JsonObject)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x022e: MOVE (r22 I:??[OBJECT, ARRAY] A[D('decodedMresult' com.google.gson.JsonObject)]) = (r25 I:??[OBJECT, ARRAY] A[D('root' com.google.gson.JsonObject)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0210: MOVE (r24 I:??[OBJECT, ARRAY] A[D('siteUrls' com.google.gson.JsonObject)]) = (r26 I:??[OBJECT, ARRAY] A[D('rootElement' com.google.gson.JsonElement)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x0212: MOVE (r16 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY] A[D('responseText' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x0214: MOVE (r15 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]) = (r28 I:??[OBJECT, ARRAY] A[D('postData' java.util.Map)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0216: MOVE (r26 I:??[OBJECT, ARRAY] A[D('rootElement' com.google.gson.JsonElement)]) = (r29 I:??[OBJECT, ARRAY] A[D('host' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x0218: MOVE (r17 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v20 */
    /* JADX WARN: Type inference failed for: r27v22 */
    /* JADX WARN: Type inference failed for: r27v24 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.Toonstream.GDMirrorbot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r7v62 */
    /* JADX WARN: Type inference failed for: r7v63 */
    /* JADX WARN: Type inference failed for: r7v64 */
    /* JADX WARN: Type inference failed for: r7v65 */
    /* JADX WARN: Type inference failed for: r7v66 */
    /* JADX WARN: Type inference failed for: r7v67 */
    /* JADX WARN: Type inference failed for: r7v68 */
    /* JADX WARN: Type inference failed for: r7v69 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 15 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:247:0x0af2 -> B:248:0x0b0b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:253:0x0b46 -> B:254:0x0b9c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:257:0x0bd6 -> B:258:0x0be3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.Toonstream.GDMirrorbot r36, java.lang.String r37, java.lang.String r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, kotlin.coroutines.Continuation<? super kotlin.Unit> r41) {
        /*
            Method dump skipped, instruction units count: 3136
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Toonstream.GDMirrorbot.getUrl$suspendImpl(com.Toonstream.GDMirrorbot, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
