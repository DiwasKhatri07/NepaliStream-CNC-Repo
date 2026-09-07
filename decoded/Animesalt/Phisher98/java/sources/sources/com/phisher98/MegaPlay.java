package com.phisher98;

import android.util.Base64;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animesalt/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/MegaPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MegaPlayResponse", "Sources", "Track", "Companion", "Animesalt"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/MegaPlay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,411:1\n73#2,5:412\n1#3:417\n2068#4,2:418\n2068#4,2:420\n777#4:422\n873#4,2:423\n2077#4,3:425\n2068#4,2:428\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/MegaPlay\n*L\n169#1:412,5\n181#1:418,2\n183#1:420,2\n231#1:422\n231#1:423,2\n232#1:425,3\n242#1:428,2\n*E\n"})
public class MegaPlay extends ExtractorApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENC_IV = "W0;27ToaUpl_P%'c";

    @NotNull
    private static final String ENC_KEY = "i?LMTAx0Q6,:}50U";

    @NotNull
    private static final String TOKEN_SECRET = "MpCdnT0k3n!9f2K#xQ7vL5mR8wN1pY4s";
    private final boolean requiresReferer;

    @NotNull
    private final String name = "MegaPlay";

    @NotNull
    private final String mainUrl = "https://megaplay.buzz";

    /* JADX INFO: renamed from: com.phisher98.MegaPlay$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MegaPlay", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {157, 169, 176, 189, 229, 233, 241, 242}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "id", "apiUrl", "$this$getUrl_u24lambda_u240", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "id", "apiUrl", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "id", "apiUrl", "response", "m3u8", "$this$forEach$iv", "element$iv", "track", "label", "file", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "$this$forEachIndexed$iv", "item$iv", "subUrl", "index$iv", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "fallbackM3u8"}, nl = {158, 412, 181, 188, 230, 239, 242, 428}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
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

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MegaPlay.getUrl$suspendImpl(MegaPlay.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:141:0x0698 A[Catch: Exception -> 0x07cc, TryCatch #20 {Exception -> 0x07cc, blocks: (B:139:0x0692, B:141:0x0698, B:144:0x06ae, B:151:0x06c6, B:158:0x06f8), top: B:341:0x0692 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x06ae A[Catch: Exception -> 0x07cc, TRY_LEAVE, TryCatch #20 {Exception -> 0x07cc, blocks: (B:139:0x0692, B:141:0x0698, B:144:0x06ae, B:151:0x06c6, B:158:0x06f8), top: B:341:0x0692 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x06b6  */
    /* JADX WARN: Code duplicated, block: B:156:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:370:0x06d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:374:0x05b7, B:110:0x05cf], limit reached: 381 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r11v56 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v66 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v76 */
    /* JADX WARN: Type inference failed for: r12v77 */
    /* JADX WARN: Type inference failed for: r12v78 */
    /* JADX WARN: Type inference failed for: r12v79 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v80 */
    /* JADX WARN: Type inference failed for: r12v81 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r13v53, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r13v54 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v62 */
    /* JADX WARN: Type inference failed for: r13v63 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r13v65 */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v67 */
    /* JADX WARN: Type inference failed for: r13v68 */
    /* JADX WARN: Type inference failed for: r13v69 */
    /* JADX WARN: Type inference failed for: r13v70 */
    /* JADX WARN: Type inference failed for: r13v71 */
    /* JADX WARN: Type inference failed for: r13v72 */
    /* JADX WARN: Type inference failed for: r13v80 */
    /* JADX WARN: Type inference failed for: r13v81 */
    /* JADX WARN: Type inference failed for: r13v82 */
    /* JADX WARN: Type inference failed for: r13v83 */
    /* JADX WARN: Type inference failed for: r13v84 */
    /* JADX WARN: Type inference failed for: r13v85 */
    /* JADX WARN: Type inference failed for: r13v86 */
    /* JADX WARN: Type inference failed for: r13v87 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v47 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v56, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v59 */
    /* JADX WARN: Type inference failed for: r14v60 */
    /* JADX WARN: Type inference failed for: r14v61 */
    /* JADX WARN: Type inference failed for: r14v63 */
    /* JADX WARN: Type inference failed for: r14v67 */
    /* JADX WARN: Type inference failed for: r14v68 */
    /* JADX WARN: Type inference failed for: r14v69 */
    /* JADX WARN: Type inference failed for: r14v70 */
    /* JADX WARN: Type inference failed for: r14v71 */
    /* JADX WARN: Type inference failed for: r14v72 */
    /* JADX WARN: Type inference failed for: r14v73 */
    /* JADX WARN: Type inference failed for: r14v74 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v18 */
    /* JADX WARN: Type inference failed for: r17v19 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v23 */
    /* JADX WARN: Type inference failed for: r17v25 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v27 */
    /* JADX WARN: Type inference failed for: r17v28 */
    /* JADX WARN: Type inference failed for: r17v29 */
    /* JADX WARN: Type inference failed for: r17v30 */
    /* JADX WARN: Type inference failed for: r17v31 */
    /* JADX WARN: Type inference failed for: r17v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v33 */
    /* JADX WARN: Type inference failed for: r17v34 */
    /* JADX WARN: Type inference failed for: r17v35 */
    /* JADX WARN: Type inference failed for: r17v36 */
    /* JADX WARN: Type inference failed for: r17v39 */
    /* JADX WARN: Type inference failed for: r17v40 */
    /* JADX WARN: Type inference failed for: r17v41 */
    /* JADX WARN: Type inference failed for: r17v42 */
    /* JADX WARN: Type inference failed for: r17v43 */
    /* JADX WARN: Type inference failed for: r17v44 */
    /* JADX WARN: Type inference failed for: r17v45 */
    /* JADX WARN: Type inference failed for: r17v46 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v71, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v83 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v19 */
    /* JADX WARN: Type inference failed for: r26v23 */
    /* JADX WARN: Type inference failed for: r29v12 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r38v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v103 */
    /* JADX WARN: Type inference failed for: r3v104 */
    /* JADX WARN: Type inference failed for: r3v105 */
    /* JADX WARN: Type inference failed for: r3v106 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r3v93 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:143:0x06a8 -> B:167:0x07a5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:156:0x06e1 -> B:166:0x07a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x0760 -> B:304:0x0784). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:249:0x0aec -> B:327:0x0b05). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.MegaPlay r54, java.lang.String r55, java.lang.String r56, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r57, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r58, kotlin.coroutines.Continuation<? super kotlin.Unit> r59) {
        /*
            Method dump skipped, instruction units count: 3402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.MegaPlay.getUrl$suspendImpl(com.phisher98.MegaPlay, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Unit getUrl$lambda$4(String result) {
        Log.INSTANCE.d("Megacloud", "JS Result: " + result);
        return Unit.INSTANCE;
    }

    static final Unit getUrl$lambda$5(String result) {
        Log.INSTANCE.d("Megacloud", "Subtitle JS Result: " + result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/phisher98/MegaPlay$MegaPlayResponse;", "", "sources", "Lcom/phisher98/MegaPlay$Sources;", "enc", "", "tracks", "", "Lcom/phisher98/MegaPlay$Track;", "<init>", "(Lcom/phisher98/MegaPlay$Sources;Ljava/lang/String;Ljava/util/List;)V", "getSources", "()Lcom/phisher98/MegaPlay$Sources;", "getEnc", "()Ljava/lang/String;", "getTracks", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Animesalt"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MegaPlayResponse {

        @Nullable
        private final String enc;

        @Nullable
        private final Sources sources;

        @NotNull
        private final List<Track> tracks;

        public MegaPlayResponse() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MegaPlayResponse copy$default(MegaPlayResponse megaPlayResponse, Sources sources, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                sources = megaPlayResponse.sources;
            }
            if ((i & 2) != 0) {
                str = megaPlayResponse.enc;
            }
            if ((i & 4) != 0) {
                list = megaPlayResponse.tracks;
            }
            return megaPlayResponse.copy(sources, str, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Sources getSources() {
            return this.sources;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEnc() {
            return this.enc;
        }

        @NotNull
        public final List<Track> component3() {
            return this.tracks;
        }

        @NotNull
        public final MegaPlayResponse copy(@Nullable Sources sources, @Nullable String enc, @NotNull List<Track> tracks) {
            return new MegaPlayResponse(sources, enc, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MegaPlayResponse)) {
                return false;
            }
            MegaPlayResponse megaPlayResponse = (MegaPlayResponse) other;
            return Intrinsics.areEqual(this.sources, megaPlayResponse.sources) && Intrinsics.areEqual(this.enc, megaPlayResponse.enc) && Intrinsics.areEqual(this.tracks, megaPlayResponse.tracks);
        }

        public int hashCode() {
            return ((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.enc != null ? this.enc.hashCode() : 0)) * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "MegaPlayResponse(sources=" + this.sources + ", enc=" + this.enc + ", tracks=" + this.tracks + ')';
        }

        public MegaPlayResponse(@Nullable Sources sources, @Nullable String enc, @NotNull List<Track> list) {
            this.sources = sources;
            this.enc = enc;
            this.tracks = list;
        }

        public /* synthetic */ MegaPlayResponse(Sources sources, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : sources, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final Sources getSources() {
            return this.sources;
        }

        @Nullable
        public final String getEnc() {
            return this.enc;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/MegaPlay$Sources;", "", "file", "", "<init>", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Animesalt"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Sources {

        @Nullable
        private final String file;

        /* JADX WARN: Illegal instructions before constructor call */
        public Sources() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Sources copy$default(Sources sources, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.file;
            }
            return sources.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final Sources copy(@Nullable String file) {
            return new Sources(file);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sources) && Intrinsics.areEqual(this.file, ((Sources) other).file);
        }

        public int hashCode() {
            if (this.file == null) {
                return 0;
            }
            return this.file.hashCode();
        }

        @NotNull
        public String toString() {
            return "Sources(file=" + this.file + ')';
        }

        public Sources(@Nullable String file) {
            this.file = file;
        }

        public /* synthetic */ Sources(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/MegaPlay$Track;", "", "file", "", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Animesalt"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final String file;

        @Nullable
        private final String kind;

        @Nullable
        private final String label;

        public Track() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            return track.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final Track copy(@Nullable String file, @Nullable String label, @Nullable String kind) {
            return new Track(file, label, kind);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind);
        }

        public int hashCode() {
            return ((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind != null ? this.kind.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@Nullable String file, @Nullable String label, @Nullable String kind) {
            this.file = file;
            this.label = label;
            this.kind = kind;
        }

        public /* synthetic */ Track(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/phisher98/MegaPlay$Companion;", "", "<init>", "()V", "ENC_KEY", "", "ENC_IV", "TOKEN_SECRET", "signMegaPlayUrl", "url", "decryptMegaPlaySources", "enc", "Animesalt"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/MegaPlay$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,411:1\n1#2:412\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String signMegaPlayUrl(String url) {
            Object obj;
            MatchResult m;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                if (StringsKt.contains$default(url, "token=", false, 2, (Object) null) || (m = Regex.find$default(new Regex("/([a-f0-9]{32})/([a-f0-9]{32})/", RegexOption.IGNORE_CASE), url, 0, 2, (Object) null)) == null) {
                    return url;
                }
                String payload = ((System.currentTimeMillis() / 1000) + 90) + '|' + ((String) m.getGroupValues().get(1)) + '/' + ((String) m.getGroupValues().get(2));
                Mac mac = Mac.getInstance("HmacSHA256");
                byte[] bytes = MegaPlay.TOKEN_SECRET.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
                byte[] bytes2 = payload.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byte[] sig = mac.doFinal(bytes2);
                StringBuilder sb = new StringBuilder();
                byte[] bytes3 = payload.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                String token = sb.append(signMegaPlayUrl$lambda$0$b64(bytes3)).append('.').append(signMegaPlayUrl$lambda$0$b64(sig)).toString();
                obj = Result.constructor-impl(url + (StringsKt.contains$default(url, "?", false, 2, (Object) null) ? "&" : "?") + "token=" + token);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = url;
            }
            return (String) obj;
        }

        private static final String signMegaPlayUrl$lambda$0$b64(byte[] b) {
            return Base64.encodeToString(b, 11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String decryptMegaPlaySources(String enc) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                String normalized = StringsKt.replace$default(StringsKt.replace$default(enc, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
                String padded = normalized + StringsKt.repeat("=", (4 - (normalized.length() % 4)) % 4);
                byte[] data = Base64.decode(padded, 0);
                byte[] keyBytes = MegaPlay.ENC_KEY.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(keyBytes, "getBytes(...)");
                byte[] key = ArraysKt.plus(keyBytes, new byte[32 - keyBytes.length]);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
                byte[] bytes = MegaPlay.ENC_IV.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                cipher.init(2, secretKeySpec, new IvParameterSpec(bytes));
                String json = new String(cipher.doFinal(data), Charsets.UTF_8);
                JSONObject el = new JSONObject(json);
                String it = el.optString("file");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                obj = Result.constructor-impl(it);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (String) (Result.isFailure-impl(obj) ? null : obj);
        }
    }
}
