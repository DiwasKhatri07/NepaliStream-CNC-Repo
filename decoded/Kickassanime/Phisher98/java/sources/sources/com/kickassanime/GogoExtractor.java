package com.kickassanime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: GogoExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kickassanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002Jr\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/kickassanime/GogoExtractor;", "", "<init>", "()V", "getKey", "", "id", "cryptoHandler", "string", "iv", "secretKeyString", "encrypt", "", "extractVidstream", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "iframeUrl", "mainApiName", "callback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "secretKey", "secretDecryptKey", "isUsingAdaptiveKeys", "isUsingAdaptiveData", "iframeDocument", "Lorg/jsoup/nodes/Document;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLorg/jsoup/nodes/Document;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GogoSources", "GogoSource", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGogoExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GogoExtractor.kt\ncom/kickassanime/GogoExtractor\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,169:1\n990#2:170\n1065#2,3:171\n*S KotlinDebug\n*F\n+ 1 GogoExtractor.kt\ncom/kickassanime/GogoExtractor\n*L\n29#1:170\n29#1:171,3\n*E\n"})
public final class GogoExtractor {

    @NotNull
    public static final GogoExtractor INSTANCE = new GogoExtractor();

    private GogoExtractor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getKey(final String id) {
        return (String) ArchComponentExtKt.safe(new Function0() { // from class: com.kickassanime.GogoExtractor$$ExternalSyntheticLambda0
            public final Object invoke() {
                return GogoExtractor.getKey$lambda$0(id);
            }
        });
    }

    static final String getKey$lambda$0(String $id) {
        String $this$map$iv = $id;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            String string = Integer.toString(item$iv$iv, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            destination$iv$iv.add(string);
        }
        String strSubstring = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null).substring(0, 32);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    static /* synthetic */ String cryptoHandler$default(GogoExtractor gogoExtractor, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return gogoExtractor.cryptoHandler(str, str2, str3, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cryptoHandler(String string, String iv, String secretKeyString, boolean encrypt) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bytes = iv.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes);
        byte[] bytes2 = secretKeyString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        SecretKeySpec secretKey = new SecretKeySpec(bytes2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        if (!encrypt) {
            cipher.init(2, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(MainAPIKt.base64DecodeArray(string)), Charsets.UTF_8);
        }
        cipher.init(1, secretKey, ivParameterSpec);
        byte[] bytes3 = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        return MainAPIKt.base64Encode(cipher.doFinal(bytes3));
    }

    public static /* synthetic */ Object extractVidstream$default(GogoExtractor gogoExtractor, String str, String str2, Function1 function1, String str3, String str4, String str5, boolean z, boolean z2, Document document, Continuation continuation, int i, Object obj) {
        Document document2;
        if ((i & 256) == 0) {
            document2 = document;
        } else {
            document2 = null;
        }
        return gogoExtractor.extractVidstream(str, str2, function1, str3, str4, str5, z, z2, document2, continuation);
    }

    /* JADX INFO: renamed from: com.kickassanime.GogoExtractor$extractVidstream$2 */
    /* JADX INFO: compiled from: GogoExtractor.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.GogoExtractor$extractVidstream$2", f = "GogoExtractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {90, 102, 112, 147, 150}, m = "invokeSuspend", n = {"id", "document", "id", "document", "foundIv", "foundKey", "foundDecryptKey", "uri", "mainUrl", "encryptedId", "id", "document", "foundIv", "foundKey", "foundDecryptKey", "uri", "mainUrl", "encryptedId", "encryptRequestData", "id", "document", "foundIv", "foundKey", "foundDecryptKey", "uri", "mainUrl", "encryptedId", "encryptRequestData", "jsonResponse", "dataencrypted", "datadecrypted", "sources", "$this$forEach$iv", "element$iv", "it", "id", "document", "foundIv", "foundKey", "foundDecryptKey", "uri", "mainUrl", "encryptedId", "encryptRequestData", "jsonResponse", "dataencrypted", "datadecrypted", "sources", "$this$forEach$iv", "element$iv", "it"}, nl = {170, 104, 111, 148, 151}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$17", "L$18"}, v = 2)
    @SourceDebugExtension({"SMAP\nGogoExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GogoExtractor.kt\ncom/kickassanime/GogoExtractor$extractVidstream$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1#2:170\n1#2:172\n63#3:171\n64#3,15:173\n50#4:188\n43#4:189\n2068#5,2:190\n2068#5,2:192\n2068#5,2:194\n*S KotlinDebug\n*F\n+ 1 GogoExtractor.kt\ncom/kickassanime/GogoExtractor$extractVidstream$2\n*L\n119#1:172\n119#1:171\n119#1:173,15\n119#1:188\n119#1:189\n146#1:190,2\n149#1:192,2\n131#1:194,2\n*E\n"})
    static final class C00002 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Document $iframeDocument;
        final /* synthetic */ String $iframeUrl;
        final /* synthetic */ boolean $isUsingAdaptiveData;
        final /* synthetic */ boolean $isUsingAdaptiveKeys;
        final /* synthetic */ String $iv;
        final /* synthetic */ String $mainApiName;
        final /* synthetic */ String $secretDecryptKey;
        final /* synthetic */ String $secretKey;
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
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00002(String str, String str2, String str3, boolean z, String str4, Document document, boolean z2, Function1<? super ExtractorLink, Unit> function1, String str5, Continuation<? super C00002> continuation) {
            super(1, continuation);
            this.$iv = str;
            this.$secretKey = str2;
            this.$secretDecryptKey = str3;
            this.$isUsingAdaptiveKeys = z;
            this.$iframeUrl = str4;
            this.$iframeDocument = document;
            this.$isUsingAdaptiveData = z2;
            this.$callback = function1;
            this.$mainApiName = str5;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00002(this.$iv, this.$secretKey, this.$secretDecryptKey, this.$isUsingAdaptiveKeys, this.$iframeUrl, this.$iframeDocument, this.$isUsingAdaptiveData, this.$callback, this.$mainApiName, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0525 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:102:0x0526  */
        /* JADX WARN: Code duplicated, block: B:41:0x023a  */
        /* JADX WARN: Code duplicated, block: B:44:0x026e  */
        /* JADX WARN: Code duplicated, block: B:46:0x0274  */
        /* JADX WARN: Code duplicated, block: B:48:0x02ba A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x02bb  */
        /* JADX WARN: Code duplicated, block: B:52:0x031c  */
        /* JADX WARN: Code duplicated, block: B:99:0x04b2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x0526 -> B:103:0x053f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x0614 -> B:115:0x062c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r37) {
            /*
                Method dump skipped, instruction units count: 1632
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kickassanime.GogoExtractor.C00002.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:23:0x00d0 A[LOOP:0: B:21:0x00ca->B:23:0x00d0, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        public static final Object invokeSuspend$invokeGogoSource(String $mainApiName, String mainUrl, GogoSource source, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
            GogoExtractor$extractVidstream$2$invokeGogoSource$1 gogoExtractor$extractVidstream$2$invokeGogoSource$1;
            GogoSource source2;
            Object objNewExtractorLink$default;
            Function1<? super ExtractorLink, Unit> function2;
            Object obj;
            Function1<? super ExtractorLink, Unit> function3 = function1;
            if (continuation instanceof GogoExtractor$extractVidstream$2$invokeGogoSource$1) {
                gogoExtractor$extractVidstream$2$invokeGogoSource$1 = (GogoExtractor$extractVidstream$2$invokeGogoSource$1) continuation;
                if ((gogoExtractor$extractVidstream$2$invokeGogoSource$1.label & Integer.MIN_VALUE) != 0) {
                    gogoExtractor$extractVidstream$2$invokeGogoSource$1.label -= Integer.MIN_VALUE;
                } else {
                    gogoExtractor$extractVidstream$2$invokeGogoSource$1 = new GogoExtractor$extractVidstream$2$invokeGogoSource$1(continuation);
                }
            } else {
                gogoExtractor$extractVidstream$2$invokeGogoSource$1 = new GogoExtractor$extractVidstream$2$invokeGogoSource$1(continuation);
            }
            GogoExtractor$extractVidstream$2$invokeGogoSource$1 gogoExtractor$extractVidstream$2$invokeGogoSource$2 = gogoExtractor$extractVidstream$2$invokeGogoSource$1;
            Object $result = gogoExtractor$extractVidstream$2$invokeGogoSource$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (gogoExtractor$extractVidstream$2$invokeGogoSource$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!StringsKt.contains$default(source.getFile(), ".m3u8", false, 2, (Object) null)) {
                        String file = source.getFile();
                        source2 = source;
                        GogoExtractor$extractVidstream$2$invokeGogoSource$2 gogoExtractor$extractVidstream$2$invokeGogoSource$3 = new GogoExtractor$extractVidstream$2$invokeGogoSource$2(mainUrl, source2, null);
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$0 = SpillingKt.nullOutSpilledVariable($mainApiName);
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$1 = SpillingKt.nullOutSpilledVariable(mainUrl);
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$2 = SpillingKt.nullOutSpilledVariable(source2);
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$4 = function3;
                        gogoExtractor$extractVidstream$2$invokeGogoSource$2.label = 2;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default($mainApiName, $mainApiName, file, (ExtractorLinkType) null, gogoExtractor$extractVidstream$2$invokeGogoSource$3, gogoExtractor$extractVidstream$2$invokeGogoSource$2, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function3;
                        function3.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    }
                    M3u8Helper.Companion companion = M3u8Helper.Companion;
                    String file2 = source.getFile();
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Origin", "https://plyr.link"));
                    gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$0 = SpillingKt.nullOutSpilledVariable($mainApiName);
                    gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$1 = SpillingKt.nullOutSpilledVariable(mainUrl);
                    gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$2 = SpillingKt.nullOutSpilledVariable(source);
                    gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$3 = function3;
                    gogoExtractor$extractVidstream$2$invokeGogoSource$2.label = 1;
                    Object objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, $mainApiName, file2, mainUrl, (Integer) null, mapMapOf, (String) null, gogoExtractor$extractVidstream$2$invokeGogoSource$2, 40, (Object) null);
                    if (objGenerateM3u8$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objGenerateM3u8$default;
                    Iterable $this$forEach$iv = (Iterable) obj;
                    for (Object element$iv : $this$forEach$iv) {
                        function3.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                case 1:
                    function3 = (Function1) gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$3;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    Iterable $this$forEach$iv2 = (Iterable) obj;
                    while (r6.hasNext()) {
                        function3.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                case 2:
                    Function1<? super ExtractorLink, Unit> function4 = (Function1) gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$4;
                    Function1<? super ExtractorLink, Unit> function5 = (Function1) gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$3;
                    GogoSource source3 = (GogoSource) gogoExtractor$extractVidstream$2$invokeGogoSource$2.L$2;
                    ResultKt.throwOnFailure($result);
                    function2 = function5;
                    function3 = function4;
                    source2 = source3;
                    objNewExtractorLink$default = $result;
                    function3.invoke(objNewExtractorLink$default);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object extractVidstream(@NotNull String iframeUrl, @NotNull String mainApiName, @NotNull Function1<? super ExtractorLink, Unit> function1, @Nullable String iv, @Nullable String secretKey, @Nullable String secretDecryptKey, boolean isUsingAdaptiveKeys, boolean isUsingAdaptiveData, @Nullable Document iframeDocument, @NotNull Continuation<? super Resource<Unit>> continuation) {
        return ArchComponentExtKt.safeApiCall(new C00002(iv, secretKey, secretDecryptKey, isUsingAdaptiveKeys, iframeUrl, iframeDocument, isUsingAdaptiveData, function1, mainApiName, null), continuation);
    }

    /* JADX INFO: compiled from: GogoExtractor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u000f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/kickassanime/GogoExtractor$GogoSources;", "", "source", "", "Lcom/kickassanime/GogoExtractor$GogoSource;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "sourceBk", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSource", "()Ljava/util/List;", "getSourceBk", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GogoSources {

        @Nullable
        private final List<GogoSource> source;

        @Nullable
        private final List<GogoSource> sourceBk;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GogoSources copy$default(GogoSources gogoSources, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = gogoSources.source;
            }
            if ((i & 2) != 0) {
                list2 = gogoSources.sourceBk;
            }
            return gogoSources.copy(list, list2);
        }

        @Nullable
        public final List<GogoSource> component1() {
            return this.source;
        }

        @Nullable
        public final List<GogoSource> component2() {
            return this.sourceBk;
        }

        @NotNull
        public final GogoSources copy(@JsonProperty("source") @Nullable List<GogoSource> source, @JsonProperty("sourceBk") @Nullable List<GogoSource> sourceBk) {
            return new GogoSources(source, sourceBk);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GogoSources)) {
                return false;
            }
            GogoSources gogoSources = (GogoSources) other;
            return Intrinsics.areEqual(this.source, gogoSources.source) && Intrinsics.areEqual(this.sourceBk, gogoSources.sourceBk);
        }

        public int hashCode() {
            return ((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.sourceBk != null ? this.sourceBk.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GogoSources(source=" + this.source + ", sourceBk=" + this.sourceBk + ')';
        }

        public GogoSources(@JsonProperty("source") @Nullable List<GogoSource> list, @JsonProperty("sourceBk") @Nullable List<GogoSource> list2) {
            this.source = list;
            this.sourceBk = list2;
        }

        @Nullable
        public final List<GogoSource> getSource() {
            return this.source;
        }

        @Nullable
        public final List<GogoSource> getSourceBk() {
            return this.sourceBk;
        }
    }

    /* JADX INFO: compiled from: GogoExtractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010\u0014\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/kickassanime/GogoExtractor$GogoSource;", "", "file", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "type", "default", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "getDefault", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GogoSource {

        @Nullable
        private final String default;

        @NotNull
        private final String file;

        @Nullable
        private final String label;

        @Nullable
        private final String type;

        public static /* synthetic */ GogoSource copy$default(GogoSource gogoSource, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gogoSource.file;
            }
            if ((i & 2) != 0) {
                str2 = gogoSource.label;
            }
            if ((i & 4) != 0) {
                str3 = gogoSource.type;
            }
            if ((i & 8) != 0) {
                str4 = gogoSource.default;
            }
            return gogoSource.copy(str, str2, str3, str4);
        }

        @NotNull
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
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDefault() {
            return this.default;
        }

        @NotNull
        public final GogoSource copy(@JsonProperty("file") @NotNull String file, @JsonProperty("label") @Nullable String label, @JsonProperty("type") @Nullable String type, @JsonProperty("default") @Nullable String str) {
            return new GogoSource(file, label, type, str);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GogoSource)) {
                return false;
            }
            GogoSource gogoSource = (GogoSource) other;
            return Intrinsics.areEqual(this.file, gogoSource.file) && Intrinsics.areEqual(this.label, gogoSource.label) && Intrinsics.areEqual(this.type, gogoSource.type) && Intrinsics.areEqual(this.default, gogoSource.default);
        }

        public int hashCode() {
            return (((((this.file.hashCode() * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.default != null ? this.default.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GogoSource(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ", default=" + this.default + ')';
        }

        public GogoSource(@JsonProperty("file") @NotNull String file, @JsonProperty("label") @Nullable String label, @JsonProperty("type") @Nullable String type, @JsonProperty("default") @Nullable String str) {
            this.file = file;
            this.label = label;
            this.type = type;
            this.default = str;
        }

        public /* synthetic */ GogoSource(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4);
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getDefault() {
            return this.default;
        }
    }
}
