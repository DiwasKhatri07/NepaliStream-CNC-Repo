package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/phisher98/KisskhSubtitle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeKisskh$3$subDeferred$1", f = "StreamPlayExtractor.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, nl = {6035}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$3$subDeferred$1\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,6034:1\n93#2,2:6035\n63#2:6037\n64#2,15:6039\n95#2,2:6056\n1#3:6038\n50#4:6054\n43#4:6055\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$3$subDeferred$1\n*L\n462#1:6035,2\n462#1:6037\n462#1:6039,15\n462#1:6056,2\n462#1:6038\n462#1:6054\n462#1:6055\n*E\n"})
final class StreamPlayExtractor$invokeKisskh$3$subDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends KisskhSubtitle>>, Object> {
    final /* synthetic */ int $epsId;
    final /* synthetic */ String $kkey1;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeKisskh$3$subDeferred$1(int i, String str, Continuation<? super StreamPlayExtractor$invokeKisskh$3$subDeferred$1> continuation) {
        super(2, continuation);
        this.$epsId = i;
        this.$kkey1 = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeKisskh$3$subDeferred$1(this.$epsId, this.$kkey1, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<KisskhSubtitle>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb A[Catch: Exception -> 0x0101, TRY_LEAVE, TryCatch #5 {Exception -> 0x0101, blocks: (B:23:0x009b, B:30:0x00c9, B:33:0x00d0, B:42:0x00eb, B:41:0x00e5, B:29:0x00be, B:22:0x0091, B:19:0x006c, B:26:0x00a2, B:36:0x00d6), top: B:52:0x006c, inners: #0, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final Object invokeSuspend(Object $result) {
        Object objSafeGet$default;
        AppUtils appUtils;
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    this.L$0 = appUtils2;
                    this.label = 1;
                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default("https://kisskh.nl/api/Sub/" + this.$epsId + "&kkey=" + this.$kkey1, null, null, null, null, false, 0, (Continuation) this, 126, null);
                    if (objSafeGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    appUtils = appUtils2;
                    break;
                    break;
                case 1:
                    appUtils = (AppUtils) this.L$0;
                    ResultKt.throwOnFailure($result);
                    objSafeGet$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String value$iv = ((NiceResponse) objSafeGet$default).getText();
            if (value$iv == null) {
                objDecodeFromString = null;
            } else {
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KisskhSubtitle.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<List<? extends KisskhSubtitle>>() { // from class: com.phisher98.StreamPlayExtractor$invokeKisskh$3$subDeferred$1$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<List<? extends KisskhSubtitle>>() { // from class: com.phisher98.StreamPlayExtractor$invokeKisskh$3$subDeferred$1$invokeSuspend$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<List<? extends KisskhSubtitle>>() { // from class: com.phisher98.StreamPlayExtractor$invokeKisskh$3$subDeferred$1$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<List<? extends KisskhSubtitle>>() { // from class: com.phisher98.StreamPlayExtractor$invokeKisskh$3$subDeferred$1$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                    }
                } catch (Exception e2) {
                    objDecodeFromString = null;
                }
            }
            return (List) objDecodeFromString;
        } catch (Exception e3) {
            return null;
        }
    }
}
