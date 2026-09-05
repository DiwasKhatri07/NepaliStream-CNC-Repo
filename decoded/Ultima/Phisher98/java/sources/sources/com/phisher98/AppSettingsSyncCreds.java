package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bk\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0006\u0012\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0003\u0010\r\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0003\u0010\u000e\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0003\u0010\u0010\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0003\u0010\u0011\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0003\u0010\u0012\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0016\b\u0003\u0010\u0013\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0016\b\u0003\u0010\u0014\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0016\b\u0003\u0010\u0015\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0016\b\u0003\u0010\u0016\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0016\b\u0003\u0010\u0017\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0016\b\u0003\u0010\u0018\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0016\b\u0003\u0010\u0019\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0016\b\u0003\u0010\u001a\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0003\u0010\u001b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0016\b\u0003\u0010\u001c\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0003\u0010\u001d\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0016\b\u0003\u0010\u001e\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u0016\b\u0003\u0010\u001f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0016\b\u0003\u0010 \u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0016\b\u0003\u0010!\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u0016\b\u0003\u0010\"\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"\u0012\u0016\b\u0003\u0010#\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#\u0012\u0016\b\u0003\u0010$\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($\u0012\u0016\b\u0003\u0010%\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(%¢\u0006\u0004\b&\u0010'J\u0006\u0010p\u001a\u00020\u0003J\u000e\u0010q\u001a\u00020\u00032\u0006\u0010r\u001a\u00020sJ\u000e\u0010t\u001a\u00020\u00032\u0006\u0010r\u001a\u00020sJ\u000e\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020wJ\u000e\u0010x\u001a\u00020\u00032\u0006\u0010v\u001a\u00020wJ\t\u0010y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010~\u001a\u00020\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\u0092\u0006\u0010\u0099\u0001\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0016\b\u0003\u0010\u0013\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0016\b\u0003\u0010\u0014\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0016\b\u0003\u0010\u0015\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u0016\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0016\b\u0003\u0010\u0017\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0016\b\u0003\u0010\u0018\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0016\b\u0003\u0010\u0019\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0016\b\u0003\u0010\u001a\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0016\b\u0003\u0010\u001c\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0016\b\u0003\u0010\u001e\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u0016\b\u0003\u0010\u001f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\u0016\b\u0003\u0010 \u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( 2\u0016\b\u0003\u0010!\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!2\u0016\b\u0003\u0010\"\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"2\u0016\b\u0003\u0010#\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#2\u0016\b\u0003\u0010$\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($2\u0016\b\u0003\u0010%\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(%HÆ\u0001J\u0016\u0010\u009a\u0001\u001a\u00020\u00032\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\f\u0010\u009c\u0001\u001a\u00030\u009d\u0001HÖ\u0081\u0004J\u000b\u0010\u009e\u0001\u001a\u00020\u0007HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010)\"\u0004\bO\u0010+R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010)\"\u0004\bQ\u0010+R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010)\"\u0004\bS\u0010+R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010)\"\u0004\bU\u0010+R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010)\"\u0004\bW\u0010+R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010)\"\u0004\bY\u0010+R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010)\"\u0004\b[\u0010+R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010)\"\u0004\b]\u0010+R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010)\"\u0004\ba\u0010+R\u001a\u0010!\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010)\"\u0004\be\u0010+R\u001a\u0010#\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010)\"\u0004\bg\u0010+R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010)\"\u0004\bi\u0010+R\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010)\"\u0004\bk\u0010+R\u0014\u0010l\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bm\u0010-R\u0011\u0010n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bo\u0010-¨\u0006\u009f\u0001"}, d2 = {"Lcom/phisher98/AppSettingsSyncCreds;", "", "useCustomDatabase", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "firebaseUrl", "", "syncKey", "deviceName", "deviceId", "backupDevice", "restoreDevice", "syncExtensions", "syncBookmarks", "syncResumeWatching", "syncSearchHistory", "syncSettings", "backupBookmarks", "backupResumeWatching", "backupSearchHistory", "backupExtensions", "backupPlayer", "backupSubtitles", "backupTheme", "backupLayout", "backupDownloads", "backupGeneral", "restoreBookmarks", "restoreResumeWatching", "restoreSearchHistory", "restoreExtensions", "restorePlayer", "restoreSubtitles", "restoreTheme", "restoreLayout", "restoreDownloads", "restoreGeneral", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZZZZZZZZZZZZZZZZZZZZZ)V", "getUseCustomDatabase", "()Z", "setUseCustomDatabase", "(Z)V", "getFirebaseUrl", "()Ljava/lang/String;", "setFirebaseUrl", "(Ljava/lang/String;)V", "getSyncKey", "setSyncKey", "getDeviceName", "setDeviceName", "getDeviceId", "setDeviceId", "getBackupDevice", "setBackupDevice", "getRestoreDevice", "setRestoreDevice", "getSyncExtensions", "setSyncExtensions", "getSyncBookmarks", "setSyncBookmarks", "getSyncResumeWatching", "setSyncResumeWatching", "getSyncSearchHistory", "setSyncSearchHistory", "getSyncSettings", "setSyncSettings", "getBackupBookmarks", "setBackupBookmarks", "getBackupResumeWatching", "setBackupResumeWatching", "getBackupSearchHistory", "setBackupSearchHistory", "getBackupExtensions", "setBackupExtensions", "getBackupPlayer", "setBackupPlayer", "getBackupSubtitles", "setBackupSubtitles", "getBackupTheme", "setBackupTheme", "getBackupLayout", "setBackupLayout", "getBackupDownloads", "setBackupDownloads", "getBackupGeneral", "setBackupGeneral", "getRestoreBookmarks", "setRestoreBookmarks", "getRestoreResumeWatching", "setRestoreResumeWatching", "getRestoreSearchHistory", "setRestoreSearchHistory", "getRestoreExtensions", "setRestoreExtensions", "getRestorePlayer", "setRestorePlayer", "getRestoreSubtitles", "setRestoreSubtitles", "getRestoreTheme", "setRestoreTheme", "getRestoreLayout", "setRestoreLayout", "getRestoreDownloads", "setRestoreDownloads", "getRestoreGeneral", "setRestoreGeneral", "defaultUrl", "getDefaultUrl", "activeUrl", "getActiveUrl", "isLoggedIn", "isBackupEnabled", "category", "Lcom/phisher98/SyncCategory;", "isRestoreEnabled", "isSettingsBackupEnabled", "sub", "Lcom/phisher98/SettingsSubCategory;", "isSettingsRestoreEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "equals", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AppSettingsSyncCreds {
    private boolean backupBookmarks;
    private boolean backupDevice;
    private boolean backupDownloads;
    private boolean backupExtensions;
    private boolean backupGeneral;
    private boolean backupLayout;
    private boolean backupPlayer;
    private boolean backupResumeWatching;
    private boolean backupSearchHistory;
    private boolean backupSubtitles;
    private boolean backupTheme;

    @NotNull
    private final String defaultUrl;

    @Nullable
    private String deviceId;

    @Nullable
    private String deviceName;

    @Nullable
    private String firebaseUrl;
    private boolean restoreBookmarks;
    private boolean restoreDevice;
    private boolean restoreDownloads;
    private boolean restoreExtensions;
    private boolean restoreGeneral;
    private boolean restoreLayout;
    private boolean restorePlayer;
    private boolean restoreResumeWatching;
    private boolean restoreSearchHistory;
    private boolean restoreSubtitles;
    private boolean restoreTheme;
    private boolean syncBookmarks;
    private boolean syncExtensions;

    @Nullable
    private String syncKey;
    private boolean syncResumeWatching;
    private boolean syncSearchHistory;
    private boolean syncSettings;
    private boolean useCustomDatabase;

    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SyncCategory.values().length];
            try {
                iArr[SyncCategory.EXTENSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SyncCategory.BOOKMARKS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SyncCategory.RESUME_WATCHING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SyncCategory.SEARCH_HISTORY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SyncCategory.SETTINGS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SettingsSubCategory.values().length];
            try {
                iArr2[SettingsSubCategory.PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[SettingsSubCategory.SUBTITLES.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[SettingsSubCategory.THEME.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[SettingsSubCategory.LAYOUT.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr2[SettingsSubCategory.DOWNLOADS.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr2[SettingsSubCategory.GENERAL.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AppSettingsSyncCreds() {
        this(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null);
    }

    public static /* synthetic */ AppSettingsSyncCreds copy$default(AppSettingsSyncCreds appSettingsSyncCreds, boolean z, String str, String str2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, int i, Object obj) {
        boolean z29;
        boolean z30;
        boolean z31 = (i & 1) != 0 ? appSettingsSyncCreds.useCustomDatabase : z;
        String str5 = (i & 2) != 0 ? appSettingsSyncCreds.firebaseUrl : str;
        String str6 = (i & 4) != 0 ? appSettingsSyncCreds.syncKey : str2;
        String str7 = (i & 8) != 0 ? appSettingsSyncCreds.deviceName : str3;
        String str8 = (i & 16) != 0 ? appSettingsSyncCreds.deviceId : str4;
        boolean z32 = (i & 32) != 0 ? appSettingsSyncCreds.backupDevice : z2;
        boolean z33 = (i & 64) != 0 ? appSettingsSyncCreds.restoreDevice : z3;
        boolean z34 = (i & 128) != 0 ? appSettingsSyncCreds.syncExtensions : z4;
        boolean z35 = (i & 256) != 0 ? appSettingsSyncCreds.syncBookmarks : z5;
        boolean z36 = (i & 512) != 0 ? appSettingsSyncCreds.syncResumeWatching : z6;
        boolean z37 = (i & 1024) != 0 ? appSettingsSyncCreds.syncSearchHistory : z7;
        boolean z38 = (i & 2048) != 0 ? appSettingsSyncCreds.syncSettings : z8;
        boolean z39 = (i & 4096) != 0 ? appSettingsSyncCreds.backupBookmarks : z9;
        boolean z40 = (i & 8192) != 0 ? appSettingsSyncCreds.backupResumeWatching : z10;
        boolean z41 = z31;
        boolean z42 = (i & 16384) != 0 ? appSettingsSyncCreds.backupSearchHistory : z11;
        boolean z43 = (i & 32768) != 0 ? appSettingsSyncCreds.backupExtensions : z12;
        boolean z44 = (i & 65536) != 0 ? appSettingsSyncCreds.backupPlayer : z13;
        boolean z45 = (i & 131072) != 0 ? appSettingsSyncCreds.backupSubtitles : z14;
        boolean z46 = (i & 262144) != 0 ? appSettingsSyncCreds.backupTheme : z15;
        boolean z47 = (i & 524288) != 0 ? appSettingsSyncCreds.backupLayout : z16;
        boolean z48 = (i & 1048576) != 0 ? appSettingsSyncCreds.backupDownloads : z17;
        boolean z49 = (i & 2097152) != 0 ? appSettingsSyncCreds.backupGeneral : z18;
        boolean z50 = (i & 4194304) != 0 ? appSettingsSyncCreds.restoreBookmarks : z19;
        boolean z51 = (i & 8388608) != 0 ? appSettingsSyncCreds.restoreResumeWatching : z20;
        boolean z52 = (i & 16777216) != 0 ? appSettingsSyncCreds.restoreSearchHistory : z21;
        boolean z53 = (i & 33554432) != 0 ? appSettingsSyncCreds.restoreExtensions : z22;
        boolean z54 = (i & 67108864) != 0 ? appSettingsSyncCreds.restorePlayer : z23;
        boolean z55 = (i & 134217728) != 0 ? appSettingsSyncCreds.restoreSubtitles : z24;
        boolean z56 = (i & 268435456) != 0 ? appSettingsSyncCreds.restoreTheme : z25;
        boolean z57 = (i & 536870912) != 0 ? appSettingsSyncCreds.restoreLayout : z26;
        boolean z58 = (i & 1073741824) != 0 ? appSettingsSyncCreds.restoreDownloads : z27;
        if ((i & Integer.MIN_VALUE) != 0) {
            z30 = z58;
            z29 = appSettingsSyncCreds.restoreGeneral;
        } else {
            z29 = z28;
            z30 = z58;
        }
        return appSettingsSyncCreds.copy(z41, str5, str6, str7, str8, z32, z33, z34, z35, z36, z37, z38, z39, z40, z42, z43, z44, z45, z46, z47, z48, z49, z50, z51, z52, z53, z54, z55, z56, z57, z30, z29);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUseCustomDatabase() {
        return this.useCustomDatabase;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getSyncResumeWatching() {
        return this.syncResumeWatching;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSyncSearchHistory() {
        return this.syncSearchHistory;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getSyncSettings() {
        return this.syncSettings;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getBackupBookmarks() {
        return this.backupBookmarks;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getBackupResumeWatching() {
        return this.backupResumeWatching;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getBackupSearchHistory() {
        return this.backupSearchHistory;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getBackupExtensions() {
        return this.backupExtensions;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getBackupPlayer() {
        return this.backupPlayer;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getBackupSubtitles() {
        return this.backupSubtitles;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getBackupTheme() {
        return this.backupTheme;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirebaseUrl() {
        return this.firebaseUrl;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getBackupLayout() {
        return this.backupLayout;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getBackupDownloads() {
        return this.backupDownloads;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getBackupGeneral() {
        return this.backupGeneral;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getRestoreBookmarks() {
        return this.restoreBookmarks;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getRestoreResumeWatching() {
        return this.restoreResumeWatching;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getRestoreSearchHistory() {
        return this.restoreSearchHistory;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getRestoreExtensions() {
        return this.restoreExtensions;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getRestorePlayer() {
        return this.restorePlayer;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getRestoreSubtitles() {
        return this.restoreSubtitles;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final boolean getRestoreTheme() {
        return this.restoreTheme;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSyncKey() {
        return this.syncKey;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getRestoreLayout() {
        return this.restoreLayout;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final boolean getRestoreDownloads() {
        return this.restoreDownloads;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final boolean getRestoreGeneral() {
        return this.restoreGeneral;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getBackupDevice() {
        return this.backupDevice;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getRestoreDevice() {
        return this.restoreDevice;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getSyncExtensions() {
        return this.syncExtensions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getSyncBookmarks() {
        return this.syncBookmarks;
    }

    @NotNull
    public final AppSettingsSyncCreds copy(@JsonProperty("useCustomDatabase") boolean useCustomDatabase, @JsonProperty("firebaseUrl") @Nullable String firebaseUrl, @JsonProperty("syncKey") @Nullable String syncKey, @JsonProperty("deviceName") @Nullable String deviceName, @JsonProperty("deviceId") @Nullable String deviceId, @JsonProperty("backupDevice") boolean backupDevice, @JsonProperty("restoreDevice") boolean restoreDevice, @JsonProperty("syncExtensions") boolean syncExtensions, @JsonProperty("syncBookmarks") boolean syncBookmarks, @JsonProperty("syncResumeWatching") boolean syncResumeWatching, @JsonProperty("syncSearchHistory") boolean syncSearchHistory, @JsonProperty("syncSettings") boolean syncSettings, @JsonProperty("backupBookmarks") boolean backupBookmarks, @JsonProperty("backupResumeWatching") boolean backupResumeWatching, @JsonProperty("backupSearchHistory") boolean backupSearchHistory, @JsonProperty("backupExtensions") boolean backupExtensions, @JsonProperty("backupPlayer") boolean backupPlayer, @JsonProperty("backupSubtitles") boolean backupSubtitles, @JsonProperty("backupTheme") boolean backupTheme, @JsonProperty("backupLayout") boolean backupLayout, @JsonProperty("backupDownloads") boolean backupDownloads, @JsonProperty("backupGeneral") boolean backupGeneral, @JsonProperty("restoreBookmarks") boolean restoreBookmarks, @JsonProperty("restoreResumeWatching") boolean restoreResumeWatching, @JsonProperty("restoreSearchHistory") boolean restoreSearchHistory, @JsonProperty("restoreExtensions") boolean restoreExtensions, @JsonProperty("restorePlayer") boolean restorePlayer, @JsonProperty("restoreSubtitles") boolean restoreSubtitles, @JsonProperty("restoreTheme") boolean restoreTheme, @JsonProperty("restoreLayout") boolean restoreLayout, @JsonProperty("restoreDownloads") boolean restoreDownloads, @JsonProperty("restoreGeneral") boolean restoreGeneral) {
        return new AppSettingsSyncCreds(useCustomDatabase, firebaseUrl, syncKey, deviceName, deviceId, backupDevice, restoreDevice, syncExtensions, syncBookmarks, syncResumeWatching, syncSearchHistory, syncSettings, backupBookmarks, backupResumeWatching, backupSearchHistory, backupExtensions, backupPlayer, backupSubtitles, backupTheme, backupLayout, backupDownloads, backupGeneral, restoreBookmarks, restoreResumeWatching, restoreSearchHistory, restoreExtensions, restorePlayer, restoreSubtitles, restoreTheme, restoreLayout, restoreDownloads, restoreGeneral);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSettingsSyncCreds)) {
            return false;
        }
        AppSettingsSyncCreds appSettingsSyncCreds = (AppSettingsSyncCreds) other;
        return this.useCustomDatabase == appSettingsSyncCreds.useCustomDatabase && Intrinsics.areEqual(this.firebaseUrl, appSettingsSyncCreds.firebaseUrl) && Intrinsics.areEqual(this.syncKey, appSettingsSyncCreds.syncKey) && Intrinsics.areEqual(this.deviceName, appSettingsSyncCreds.deviceName) && Intrinsics.areEqual(this.deviceId, appSettingsSyncCreds.deviceId) && this.backupDevice == appSettingsSyncCreds.backupDevice && this.restoreDevice == appSettingsSyncCreds.restoreDevice && this.syncExtensions == appSettingsSyncCreds.syncExtensions && this.syncBookmarks == appSettingsSyncCreds.syncBookmarks && this.syncResumeWatching == appSettingsSyncCreds.syncResumeWatching && this.syncSearchHistory == appSettingsSyncCreds.syncSearchHistory && this.syncSettings == appSettingsSyncCreds.syncSettings && this.backupBookmarks == appSettingsSyncCreds.backupBookmarks && this.backupResumeWatching == appSettingsSyncCreds.backupResumeWatching && this.backupSearchHistory == appSettingsSyncCreds.backupSearchHistory && this.backupExtensions == appSettingsSyncCreds.backupExtensions && this.backupPlayer == appSettingsSyncCreds.backupPlayer && this.backupSubtitles == appSettingsSyncCreds.backupSubtitles && this.backupTheme == appSettingsSyncCreds.backupTheme && this.backupLayout == appSettingsSyncCreds.backupLayout && this.backupDownloads == appSettingsSyncCreds.backupDownloads && this.backupGeneral == appSettingsSyncCreds.backupGeneral && this.restoreBookmarks == appSettingsSyncCreds.restoreBookmarks && this.restoreResumeWatching == appSettingsSyncCreds.restoreResumeWatching && this.restoreSearchHistory == appSettingsSyncCreds.restoreSearchHistory && this.restoreExtensions == appSettingsSyncCreds.restoreExtensions && this.restorePlayer == appSettingsSyncCreds.restorePlayer && this.restoreSubtitles == appSettingsSyncCreds.restoreSubtitles && this.restoreTheme == appSettingsSyncCreds.restoreTheme && this.restoreLayout == appSettingsSyncCreds.restoreLayout && this.restoreDownloads == appSettingsSyncCreds.restoreDownloads && this.restoreGeneral == appSettingsSyncCreds.restoreGeneral;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.useCustomDatabase) * 31) + (this.firebaseUrl == null ? 0 : this.firebaseUrl.hashCode())) * 31) + (this.syncKey == null ? 0 : this.syncKey.hashCode())) * 31) + (this.deviceName == null ? 0 : this.deviceName.hashCode())) * 31) + (this.deviceId != null ? this.deviceId.hashCode() : 0)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupDevice)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreDevice)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.syncExtensions)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.syncBookmarks)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.syncResumeWatching)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.syncSearchHistory)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.syncSettings)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupBookmarks)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupResumeWatching)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupSearchHistory)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupExtensions)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupPlayer)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupSubtitles)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupTheme)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupLayout)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupDownloads)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.backupGeneral)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreBookmarks)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreResumeWatching)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreSearchHistory)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreExtensions)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restorePlayer)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreSubtitles)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreTheme)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreLayout)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreDownloads)) * 31) + AppSettingsSyncCreds$$ExternalSyntheticBackport0.m0m(this.restoreGeneral);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppSettingsSyncCreds(useCustomDatabase=").append(this.useCustomDatabase).append(", firebaseUrl=").append(this.firebaseUrl).append(", syncKey=").append(this.syncKey).append(", deviceName=").append(this.deviceName).append(", deviceId=").append(this.deviceId).append(", backupDevice=").append(this.backupDevice).append(", restoreDevice=").append(this.restoreDevice).append(", syncExtensions=").append(this.syncExtensions).append(", syncBookmarks=").append(this.syncBookmarks).append(", syncResumeWatching=").append(this.syncResumeWatching).append(", syncSearchHistory=").append(this.syncSearchHistory).append(", syncSettings=");
        sb.append(this.syncSettings).append(", backupBookmarks=").append(this.backupBookmarks).append(", backupResumeWatching=").append(this.backupResumeWatching).append(", backupSearchHistory=").append(this.backupSearchHistory).append(", backupExtensions=").append(this.backupExtensions).append(", backupPlayer=").append(this.backupPlayer).append(", backupSubtitles=").append(this.backupSubtitles).append(", backupTheme=").append(this.backupTheme).append(", backupLayout=").append(this.backupLayout).append(", backupDownloads=").append(this.backupDownloads).append(", backupGeneral=").append(this.backupGeneral).append(", restoreBookmarks=").append(this.restoreBookmarks);
        sb.append(", restoreResumeWatching=").append(this.restoreResumeWatching).append(", restoreSearchHistory=").append(this.restoreSearchHistory).append(", restoreExtensions=").append(this.restoreExtensions).append(", restorePlayer=").append(this.restorePlayer).append(", restoreSubtitles=").append(this.restoreSubtitles).append(", restoreTheme=").append(this.restoreTheme).append(", restoreLayout=").append(this.restoreLayout).append(", restoreDownloads=").append(this.restoreDownloads).append(", restoreGeneral=").append(this.restoreGeneral).append(')');
        return sb.toString();
    }

    public AppSettingsSyncCreds(@JsonProperty("useCustomDatabase") boolean useCustomDatabase, @JsonProperty("firebaseUrl") @Nullable String firebaseUrl, @JsonProperty("syncKey") @Nullable String syncKey, @JsonProperty("deviceName") @Nullable String deviceName, @JsonProperty("deviceId") @Nullable String deviceId, @JsonProperty("backupDevice") boolean backupDevice, @JsonProperty("restoreDevice") boolean restoreDevice, @JsonProperty("syncExtensions") boolean syncExtensions, @JsonProperty("syncBookmarks") boolean syncBookmarks, @JsonProperty("syncResumeWatching") boolean syncResumeWatching, @JsonProperty("syncSearchHistory") boolean syncSearchHistory, @JsonProperty("syncSettings") boolean syncSettings, @JsonProperty("backupBookmarks") boolean backupBookmarks, @JsonProperty("backupResumeWatching") boolean backupResumeWatching, @JsonProperty("backupSearchHistory") boolean backupSearchHistory, @JsonProperty("backupExtensions") boolean backupExtensions, @JsonProperty("backupPlayer") boolean backupPlayer, @JsonProperty("backupSubtitles") boolean backupSubtitles, @JsonProperty("backupTheme") boolean backupTheme, @JsonProperty("backupLayout") boolean backupLayout, @JsonProperty("backupDownloads") boolean backupDownloads, @JsonProperty("backupGeneral") boolean backupGeneral, @JsonProperty("restoreBookmarks") boolean restoreBookmarks, @JsonProperty("restoreResumeWatching") boolean restoreResumeWatching, @JsonProperty("restoreSearchHistory") boolean restoreSearchHistory, @JsonProperty("restoreExtensions") boolean restoreExtensions, @JsonProperty("restorePlayer") boolean restorePlayer, @JsonProperty("restoreSubtitles") boolean restoreSubtitles, @JsonProperty("restoreTheme") boolean restoreTheme, @JsonProperty("restoreLayout") boolean restoreLayout, @JsonProperty("restoreDownloads") boolean restoreDownloads, @JsonProperty("restoreGeneral") boolean restoreGeneral) {
        this.useCustomDatabase = useCustomDatabase;
        this.firebaseUrl = firebaseUrl;
        this.syncKey = syncKey;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.backupDevice = backupDevice;
        this.restoreDevice = restoreDevice;
        this.syncExtensions = syncExtensions;
        this.syncBookmarks = syncBookmarks;
        this.syncResumeWatching = syncResumeWatching;
        this.syncSearchHistory = syncSearchHistory;
        this.syncSettings = syncSettings;
        this.backupBookmarks = backupBookmarks;
        this.backupResumeWatching = backupResumeWatching;
        this.backupSearchHistory = backupSearchHistory;
        this.backupExtensions = backupExtensions;
        this.backupPlayer = backupPlayer;
        this.backupSubtitles = backupSubtitles;
        this.backupTheme = backupTheme;
        this.backupLayout = backupLayout;
        this.backupDownloads = backupDownloads;
        this.backupGeneral = backupGeneral;
        this.restoreBookmarks = restoreBookmarks;
        this.restoreResumeWatching = restoreResumeWatching;
        this.restoreSearchHistory = restoreSearchHistory;
        this.restoreExtensions = restoreExtensions;
        this.restorePlayer = restorePlayer;
        this.restoreSubtitles = restoreSubtitles;
        this.restoreTheme = restoreTheme;
        this.restoreLayout = restoreLayout;
        this.restoreDownloads = restoreDownloads;
        this.restoreGeneral = restoreGeneral;
        this.defaultUrl = "https://cloudstream-ultima-sync-default-rtdb.firebaseio.com/";
    }

    public /* synthetic */ AppSettingsSyncCreds(boolean z, String str, String str2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) == 0 ? str4 : null, (i & 32) != 0 ? false : z2, (i & 64) == 0 ? z3 : false, (i & 128) != 0 ? true : z4, (i & 256) != 0 ? true : z5, (i & 512) != 0 ? true : z6, (i & 1024) != 0 ? true : z7, (i & 2048) != 0 ? true : z8, (i & 4096) != 0 ? true : z9, (i & 8192) != 0 ? true : z10, (i & 16384) != 0 ? true : z11, (i & 32768) != 0 ? true : z12, (i & 65536) != 0 ? true : z13, (i & 131072) != 0 ? true : z14, (i & 262144) != 0 ? true : z15, (i & 524288) != 0 ? true : z16, (i & 1048576) != 0 ? true : z17, (i & 2097152) != 0 ? true : z18, (i & 4194304) != 0 ? true : z19, (i & 8388608) != 0 ? true : z20, (i & 16777216) != 0 ? true : z21, (i & 33554432) != 0 ? true : z22, (i & 67108864) != 0 ? true : z23, (i & 134217728) != 0 ? true : z24, (i & 268435456) != 0 ? true : z25, (i & 536870912) != 0 ? true : z26, (i & 1073741824) != 0 ? true : z27, (i & Integer.MIN_VALUE) != 0 ? true : z28);
    }

    public final boolean getUseCustomDatabase() {
        return this.useCustomDatabase;
    }

    public final void setUseCustomDatabase(boolean z) {
        this.useCustomDatabase = z;
    }

    @Nullable
    public final String getFirebaseUrl() {
        return this.firebaseUrl;
    }

    public final void setFirebaseUrl(@Nullable String str) {
        this.firebaseUrl = str;
    }

    @Nullable
    public final String getSyncKey() {
        return this.syncKey;
    }

    public final void setSyncKey(@Nullable String str) {
        this.syncKey = str;
    }

    @Nullable
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(@Nullable String str) {
        this.deviceName = str;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(@Nullable String str) {
        this.deviceId = str;
    }

    public final boolean getBackupDevice() {
        return this.backupDevice;
    }

    public final void setBackupDevice(boolean z) {
        this.backupDevice = z;
    }

    public final boolean getRestoreDevice() {
        return this.restoreDevice;
    }

    public final void setRestoreDevice(boolean z) {
        this.restoreDevice = z;
    }

    public final boolean getSyncExtensions() {
        return this.syncExtensions;
    }

    public final void setSyncExtensions(boolean z) {
        this.syncExtensions = z;
    }

    public final boolean getSyncBookmarks() {
        return this.syncBookmarks;
    }

    public final void setSyncBookmarks(boolean z) {
        this.syncBookmarks = z;
    }

    public final boolean getSyncResumeWatching() {
        return this.syncResumeWatching;
    }

    public final void setSyncResumeWatching(boolean z) {
        this.syncResumeWatching = z;
    }

    public final boolean getSyncSearchHistory() {
        return this.syncSearchHistory;
    }

    public final void setSyncSearchHistory(boolean z) {
        this.syncSearchHistory = z;
    }

    public final boolean getSyncSettings() {
        return this.syncSettings;
    }

    public final void setSyncSettings(boolean z) {
        this.syncSettings = z;
    }

    public final boolean getBackupBookmarks() {
        return this.backupBookmarks;
    }

    public final void setBackupBookmarks(boolean z) {
        this.backupBookmarks = z;
    }

    public final boolean getBackupResumeWatching() {
        return this.backupResumeWatching;
    }

    public final void setBackupResumeWatching(boolean z) {
        this.backupResumeWatching = z;
    }

    public final boolean getBackupSearchHistory() {
        return this.backupSearchHistory;
    }

    public final void setBackupSearchHistory(boolean z) {
        this.backupSearchHistory = z;
    }

    public final boolean getBackupExtensions() {
        return this.backupExtensions;
    }

    public final void setBackupExtensions(boolean z) {
        this.backupExtensions = z;
    }

    public final boolean getBackupPlayer() {
        return this.backupPlayer;
    }

    public final void setBackupPlayer(boolean z) {
        this.backupPlayer = z;
    }

    public final boolean getBackupSubtitles() {
        return this.backupSubtitles;
    }

    public final void setBackupSubtitles(boolean z) {
        this.backupSubtitles = z;
    }

    public final boolean getBackupTheme() {
        return this.backupTheme;
    }

    public final void setBackupTheme(boolean z) {
        this.backupTheme = z;
    }

    public final boolean getBackupLayout() {
        return this.backupLayout;
    }

    public final void setBackupLayout(boolean z) {
        this.backupLayout = z;
    }

    public final boolean getBackupDownloads() {
        return this.backupDownloads;
    }

    public final void setBackupDownloads(boolean z) {
        this.backupDownloads = z;
    }

    public final boolean getBackupGeneral() {
        return this.backupGeneral;
    }

    public final void setBackupGeneral(boolean z) {
        this.backupGeneral = z;
    }

    public final boolean getRestoreBookmarks() {
        return this.restoreBookmarks;
    }

    public final void setRestoreBookmarks(boolean z) {
        this.restoreBookmarks = z;
    }

    public final boolean getRestoreResumeWatching() {
        return this.restoreResumeWatching;
    }

    public final void setRestoreResumeWatching(boolean z) {
        this.restoreResumeWatching = z;
    }

    public final boolean getRestoreSearchHistory() {
        return this.restoreSearchHistory;
    }

    public final void setRestoreSearchHistory(boolean z) {
        this.restoreSearchHistory = z;
    }

    public final boolean getRestoreExtensions() {
        return this.restoreExtensions;
    }

    public final void setRestoreExtensions(boolean z) {
        this.restoreExtensions = z;
    }

    public final boolean getRestorePlayer() {
        return this.restorePlayer;
    }

    public final void setRestorePlayer(boolean z) {
        this.restorePlayer = z;
    }

    public final boolean getRestoreSubtitles() {
        return this.restoreSubtitles;
    }

    public final void setRestoreSubtitles(boolean z) {
        this.restoreSubtitles = z;
    }

    public final boolean getRestoreTheme() {
        return this.restoreTheme;
    }

    public final void setRestoreTheme(boolean z) {
        this.restoreTheme = z;
    }

    public final boolean getRestoreLayout() {
        return this.restoreLayout;
    }

    public final void setRestoreLayout(boolean z) {
        this.restoreLayout = z;
    }

    public final boolean getRestoreDownloads() {
        return this.restoreDownloads;
    }

    public final void setRestoreDownloads(boolean z) {
        this.restoreDownloads = z;
    }

    public final boolean getRestoreGeneral() {
        return this.restoreGeneral;
    }

    public final void setRestoreGeneral(boolean z) {
        this.restoreGeneral = z;
    }

    @NotNull
    public final String getDefaultUrl() {
        return this.defaultUrl;
    }

    @NotNull
    public final String getActiveUrl() {
        String url = this.useCustomDatabase ? this.firebaseUrl : this.defaultUrl;
        String str = url;
        if (str == null || str.length() == 0) {
            return this.defaultUrl;
        }
        return StringsKt.endsWith$default(url, "/", false, 2, (Object) null) ? url : url + '/';
    }

    public final boolean isLoggedIn() {
        String str = this.syncKey;
        return !(str == null || str.length() == 0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isBackupEnabled(@NotNull SyncCategory category) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return this.backupExtensions;
            case 2:
                return this.backupBookmarks;
            case 3:
                return this.backupResumeWatching;
            case 4:
                return this.backupSearchHistory;
            case 5:
                return this.backupPlayer || this.backupSubtitles || this.backupTheme || this.backupLayout || this.backupDownloads || this.backupGeneral;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isRestoreEnabled(@NotNull SyncCategory category) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return this.restoreExtensions;
            case 2:
                return this.restoreBookmarks;
            case 3:
                return this.restoreResumeWatching;
            case 4:
                return this.restoreSearchHistory;
            case 5:
                return this.restorePlayer || this.restoreSubtitles || this.restoreTheme || this.restoreLayout || this.restoreDownloads || this.restoreGeneral;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isSettingsBackupEnabled(@NotNull SettingsSubCategory sub) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$1[sub.ordinal()]) {
            case 1:
                return this.backupPlayer;
            case 2:
                return this.backupSubtitles;
            case 3:
                return this.backupTheme;
            case 4:
                return this.backupLayout;
            case 5:
                return this.backupDownloads;
            case 6:
                return this.backupGeneral;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isSettingsRestoreEnabled(@NotNull SettingsSubCategory sub) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$1[sub.ordinal()]) {
            case 1:
                return this.restorePlayer;
            case 2:
                return this.restoreSubtitles;
            case 3:
                return this.restoreTheme;
            case 4:
                return this.restoreLayout;
            case 5:
                return this.restoreDownloads;
            case 6:
                return this.restoreGeneral;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
