package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"loadCustomExtractor", "", "name", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "quality", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAnimeData", "Lcom/phisher98/MetaAnimeData;", "jsonString", "AnimePahe"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,284:1\n93#2,2:285\n63#2:287\n64#2,15:289\n95#2,2:306\n1#3:288\n50#4:304\n43#4:305\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n*L\n275#1:285,2\n275#1:287\n275#1:289,15\n275#1:306,2\n275#1:288\n275#1:304\n275#1:305\n*E\n"})
public final class UtilsKt {

    /* JADX INFO: renamed from: com.phisher98.UtilsKt$loadCustomExtractor$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {31}, m = "loadCustomExtractor", n = {"name", "url", "referer", "subtitleCallback", "callback", "quality"}, nl = {57}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.loadCustomExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadCustomExtractor(@Nullable final String name, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull Continuation<? super Unit> continuation) {
        C00181 c00181;
        Object objLoadExtractor;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuation);
            }
        } else {
            c00181 = new C00181(continuation);
        }
        Object $result = c00181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00181.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Result.Companion companion = Result.Companion;
                    Function1 function3 = new Function1() { // from class: com.phisher98.UtilsKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return UtilsKt.loadCustomExtractor$lambda$0$0(name, function2, quality, (ExtractorLink) obj);
                        }
                    };
                    c00181.L$0 = SpillingKt.nullOutSpilledVariable(name);
                    c00181.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00181.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                    c00181.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    c00181.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                    c00181.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                    c00181.label = 1;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00181);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objLoadExtractor = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadCustomExtractor$default(String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        return loadCustomExtractor(str, str2, str3, function1, function2, num, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadCustomExtractor$lambda$0$0(String $name, Function1 $callback, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$loadCustomExtractor$2$1$1($name, link, $callback, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #4 {Exception -> 0x0098, blocks: (B:12:0x0032, B:19:0x0060, B:22:0x0067, B:30:0x0082, B:29:0x007c, B:18:0x0055, B:11:0x0028, B:15:0x0039, B:8:0x000f, B:24:0x006d), top: B:44:0x000f, inners: #1, #3, #6 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            if (jsonString == null) {
                objDecodeFromString = null;
            } else {
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(MetaAnimeData.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(MetaAnimeData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.phisher98.UtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.phisher98.UtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.phisher98.UtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.phisher98.UtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    }
                } catch (Exception e2) {
                    objDecodeFromString = null;
                }
            }
            return (MetaAnimeData) objDecodeFromString;
        } catch (Exception e3) {
            return null;
        }
    }
}
