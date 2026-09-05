package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\by\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020#\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010%\u001a\u00020&\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018\u0012\u0006\u0010+\u001a\u00020\f\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020.\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0018\u0012\u0016\b\u0001\u00101\u001a\u00020\u000e:\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u000e\u0012\u0006\u00107\u001a\u000208\u0012\u0006\u00109\u001a\u00020\f\u0012\u0006\u0010:\u001a\u00020\f\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010>\u001a\u00020\f\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0001\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0018\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0001\u0012\u0016\b\u0001\u0010D\u001a\u00020\u000e:\f\b2\u0012\b\b3\u0012\u0004\b\b(E¢\u0006\u0004\bF\u0010GJ\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\fHÆ\u0003J\u0010\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020#HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020&HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0012\u0010£\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\fHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020.HÆ\u0003J\u0010\u0010§\u0001\u001a\b\u0012\u0004\u0012\u0002000\u0018HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010«\u0001\u001a\u000208HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\fHÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010±\u0001\u001a\u00020\fHÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020A0\u0018HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u000eHÆ\u0003Jô\u0004\u0010·\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020.2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00182\u0016\b\u0003\u00101\u001a\u00020\u000e:\f\b2\u0012\b\b3\u0012\u0004\b\b(42\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010:\u001a\u00020\f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010>\u001a\u00020\f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00182\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00012\u0016\b\u0003\u0010D\u001a\u00020\u000e:\f\b2\u0012\b\b3\u0012\u0004\b\b(EHÆ\u0001J\u0016\u0010¸\u0001\u001a\u00020\u000e2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\f\u0010º\u0001\u001a\u00030»\u0001HÖ\u0081\u0004J\u000b\u0010¼\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010IR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010PR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bV\u0010PR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bW\u0010PR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bX\u0010PR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bY\u0010SR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010UR\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b[\u0010SR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010PR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010IR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\b\n\u0000\u001a\u0004\b`\u0010_R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\ba\u0010SR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\bb\u0010_R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\b\n\u0000\u001a\u0004\bc\u0010_R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bd\u0010PR\u0013\u0010 \u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\be\u0010PR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010IR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0013\u0010$\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bi\u0010PR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010'\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bl\u0010PR\u0013\u0010(\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bm\u0010PR\u0013\u0010)\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bn\u0010PR\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bo\u0010_R\u0011\u0010+\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bp\u0010SR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010IR\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0018¢\u0006\b\n\u0000\u001a\u0004\bt\u0010_R\u0011\u00101\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010UR\u0011\u00105\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010IR\u0011\u00106\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010UR\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u00109\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\by\u0010SR\u0011\u0010:\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bz\u0010SR\u0013\u0010;\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b{\u0010PR\u0013\u0010<\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b|\u0010PR\u0013\u0010=\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b}\u0010PR\u0011\u0010>\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b~\u0010SR\u0013\u0010?\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010PR\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010_R\u0014\u0010B\u001a\u0004\u0018\u00010\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010PR\u0014\u0010C\u001a\u0004\u0018\u00010\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010PR\u0012\u0010D\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010U¨\u0006½\u0001"}, d2 = {"Lcom/MPlayer/MovieTrailer;", "", "description", "", "title", "releaseDate", "stream", "Lcom/MPlayer/MovieStream2;", "type", "tvodPackImageInfo", "tvodDetail", "watchAt", "", "lastWatched", "", "lastWatchedEpisodeId", "subtitleLanguageCode", "audioTrackLanguageCode", "statusCode", "lastTvShowEpisode", "rating", "descriptor", "id", "languages", "", "languagesDetails", "Lcom/MPlayer/MovieLanguagesDetail2;", "duration", "genres", "genresDetails", "Lcom/MPlayer/MovieGenresDetail2;", "secondaryGenres", "publishTime", "shareUrl", "image", "Lcom/MPlayer/MovieImage2;", "titleContentImageInfo", "trailerPreview", "Lcom/MPlayer/MovieTrailerPreview;", "trailer", "firstVideo", "container", "contributors", "sequence", "subType", "gifVideoUrl", "Lcom/MPlayer/MovieGifVideoUrl;", "gifVideoUrlInfo", "Lcom/MPlayer/MovieGifVideoUrlInfo;", "canPreviewGifvideo", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "canPreviewGIFVideo", "webUrl", "isOptimizedDescription", "publisher", "Lcom/MPlayer/MoviePublisher;", "childCount", "videoCount", "detailKey", "inlineData", "statistics", "viewCount", "overlayImages", "tags", "Lcom/MPlayer/MovieTag;", "tabs", "goldBadgeImageInfo", "existInCw", "existInCW", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/MovieStream2;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;JZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JZJLjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Lcom/MPlayer/MovieImage2;Ljava/lang/Object;Lcom/MPlayer/MovieTrailerPreview;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;JLjava/lang/String;Lcom/MPlayer/MovieGifVideoUrl;Ljava/util/List;ZLjava/lang/String;ZLcom/MPlayer/MoviePublisher;JJLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getDescription", "()Ljava/lang/String;", "getTitle", "getReleaseDate", "getStream", "()Lcom/MPlayer/MovieStream2;", "getType", "getTvodPackImageInfo", "()Ljava/lang/Object;", "getTvodDetail", "getWatchAt", "()J", "getLastWatched", "()Z", "getLastWatchedEpisodeId", "getSubtitleLanguageCode", "getAudioTrackLanguageCode", "getStatusCode", "getLastTvShowEpisode", "getRating", "getDescriptor", "getId", "getLanguages", "()Ljava/util/List;", "getLanguagesDetails", "getDuration", "getGenres", "getGenresDetails", "getSecondaryGenres", "getPublishTime", "getShareUrl", "getImage", "()Lcom/MPlayer/MovieImage2;", "getTitleContentImageInfo", "getTrailerPreview", "()Lcom/MPlayer/MovieTrailerPreview;", "getTrailer", "getFirstVideo", "getContainer", "getContributors", "getSequence", "getSubType", "getGifVideoUrl", "()Lcom/MPlayer/MovieGifVideoUrl;", "getGifVideoUrlInfo", "getCanPreviewGifvideo", "getWebUrl", "getPublisher", "()Lcom/MPlayer/MoviePublisher;", "getChildCount", "getVideoCount", "getDetailKey", "getInlineData", "getStatistics", "getViewCount", "getOverlayImages", "getTags", "getTabs", "getGoldBadgeImageInfo", "getExistInCw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieTrailer {

    @Nullable
    private final Object audioTrackLanguageCode;
    private final boolean canPreviewGifvideo;
    private final long childCount;

    @Nullable
    private final Object container;

    @NotNull
    private final List<Object> contributors;

    @NotNull
    private final String description;

    @Nullable
    private final Object descriptor;

    @Nullable
    private final Object detailKey;
    private final long duration;
    private final boolean existInCw;

    @Nullable
    private final Object firstVideo;

    @NotNull
    private final List<String> genres;

    @NotNull
    private final List<MovieGenresDetail2> genresDetails;

    @NotNull
    private final MovieGifVideoUrl gifVideoUrl;

    @NotNull
    private final List<MovieGifVideoUrlInfo> gifVideoUrlInfo;

    @Nullable
    private final Object goldBadgeImageInfo;

    @NotNull
    private final String id;

    @NotNull
    private final MovieImage2 image;

    @Nullable
    private final Object inlineData;
    private final boolean isOptimizedDescription;

    @NotNull
    private final List<String> languages;

    @NotNull
    private final List<MovieLanguagesDetail2> languagesDetails;
    private final boolean lastTvShowEpisode;
    private final boolean lastWatched;

    @Nullable
    private final Object lastWatchedEpisodeId;

    @Nullable
    private final Object overlayImages;

    @Nullable
    private final Object publishTime;

    @NotNull
    private final MoviePublisher publisher;
    private final long rating;

    @NotNull
    private final String releaseDate;

    @Nullable
    private final Object secondaryGenres;
    private final long sequence;

    @NotNull
    private final String shareUrl;

    @Nullable
    private final Object statistics;
    private final long statusCode;

    @NotNull
    private final MovieStream2 stream;

    @NotNull
    private final String subType;

    @Nullable
    private final Object subtitleLanguageCode;

    @Nullable
    private final Object tabs;

    @NotNull
    private final List<MovieTag> tags;

    @NotNull
    private final String title;

    @Nullable
    private final Object titleContentImageInfo;

    @Nullable
    private final Object trailer;

    @NotNull
    private final MovieTrailerPreview trailerPreview;

    @Nullable
    private final Object tvodDetail;

    @Nullable
    private final Object tvodPackImageInfo;

    @NotNull
    private final String type;
    private final long videoCount;
    private final long viewCount;
    private final long watchAt;

    @NotNull
    private final String webUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovieTrailer copy$default(MovieTrailer movieTrailer, String str, String str2, String str3, MovieStream2 movieStream2, String str4, Object obj, Object obj2, long j, boolean z, Object obj3, Object obj4, Object obj5, long j2, boolean z2, long j3, Object obj6, String str5, List list, List list2, long j4, List list3, List list4, Object obj7, Object obj8, String str6, MovieImage2 movieImage2, Object obj9, MovieTrailerPreview movieTrailerPreview, Object obj10, Object obj11, Object obj12, List list5, long j5, String str7, MovieGifVideoUrl movieGifVideoUrl, List list6, boolean z3, String str8, boolean z4, MoviePublisher moviePublisher, long j6, long j7, Object obj13, Object obj14, Object obj15, long j8, Object obj16, List list7, Object obj17, Object obj18, boolean z5, int i, int i2, Object obj19) {
        String str9 = (i & 1) != 0 ? movieTrailer.description : str;
        String str10 = (i & 2) != 0 ? movieTrailer.title : str2;
        String str11 = (i & 4) != 0 ? movieTrailer.releaseDate : str3;
        MovieStream2 movieStream3 = (i & 8) != 0 ? movieTrailer.stream : movieStream2;
        String str12 = (i & 16) != 0 ? movieTrailer.type : str4;
        Object obj20 = (i & 32) != 0 ? movieTrailer.tvodPackImageInfo : obj;
        Object obj21 = (i & 64) != 0 ? movieTrailer.tvodDetail : obj2;
        long j9 = (i & 128) != 0 ? movieTrailer.watchAt : j;
        boolean z6 = (i & 256) != 0 ? movieTrailer.lastWatched : z;
        Object obj22 = (i & 512) != 0 ? movieTrailer.lastWatchedEpisodeId : obj3;
        Object obj23 = (i & 1024) != 0 ? movieTrailer.subtitleLanguageCode : obj4;
        Object obj24 = (i & 2048) != 0 ? movieTrailer.audioTrackLanguageCode : obj5;
        String str13 = str9;
        String str14 = str10;
        long j10 = (i & 4096) != 0 ? movieTrailer.statusCode : j2;
        boolean z7 = (i & 8192) != 0 ? movieTrailer.lastTvShowEpisode : z2;
        long j11 = (i & 16384) != 0 ? movieTrailer.rating : j3;
        Object obj25 = (i & 32768) != 0 ? movieTrailer.descriptor : obj6;
        String str15 = (i & 65536) != 0 ? movieTrailer.id : str5;
        List list8 = (i & 131072) != 0 ? movieTrailer.languages : list;
        List list9 = (i & 262144) != 0 ? movieTrailer.languagesDetails : list2;
        long j12 = j11;
        long j13 = (i & 524288) != 0 ? movieTrailer.duration : j4;
        List list10 = list9;
        List list11 = (i & 1048576) != 0 ? movieTrailer.genres : list3;
        List list12 = (i & 2097152) != 0 ? movieTrailer.genresDetails : list4;
        Object obj26 = (i & 4194304) != 0 ? movieTrailer.secondaryGenres : obj7;
        Object obj27 = (i & 8388608) != 0 ? movieTrailer.publishTime : obj8;
        String str16 = (i & 16777216) != 0 ? movieTrailer.shareUrl : str6;
        MovieImage2 movieImage3 = (i & 33554432) != 0 ? movieTrailer.image : movieImage2;
        Object obj28 = (i & 67108864) != 0 ? movieTrailer.titleContentImageInfo : obj9;
        MovieTrailerPreview movieTrailerPreview2 = (i & 134217728) != 0 ? movieTrailer.trailerPreview : movieTrailerPreview;
        Object obj29 = (i & 268435456) != 0 ? movieTrailer.trailer : obj10;
        Object obj30 = (i & 536870912) != 0 ? movieTrailer.firstVideo : obj11;
        Object obj31 = (i & 1073741824) != 0 ? movieTrailer.container : obj12;
        List list13 = (i & Integer.MIN_VALUE) != 0 ? movieTrailer.contributors : list5;
        long j14 = (i2 & 1) != 0 ? movieTrailer.sequence : j5;
        List list14 = list13;
        String str17 = (i2 & 2) != 0 ? movieTrailer.subType : str7;
        MovieGifVideoUrl movieGifVideoUrl2 = (i2 & 4) != 0 ? movieTrailer.gifVideoUrl : movieGifVideoUrl;
        List list15 = (i2 & 8) != 0 ? movieTrailer.gifVideoUrlInfo : list6;
        boolean z8 = (i2 & 16) != 0 ? movieTrailer.canPreviewGifvideo : z3;
        String str18 = (i2 & 32) != 0 ? movieTrailer.webUrl : str8;
        boolean z9 = (i2 & 64) != 0 ? movieTrailer.isOptimizedDescription : z4;
        MoviePublisher moviePublisher2 = (i2 & 128) != 0 ? movieTrailer.publisher : moviePublisher;
        long j15 = j14;
        long j16 = (i2 & 256) != 0 ? movieTrailer.childCount : j6;
        long j17 = (i2 & 512) != 0 ? movieTrailer.videoCount : j7;
        return movieTrailer.copy(str13, str14, str11, movieStream3, str12, obj20, obj21, j9, z6, obj22, obj23, obj24, j10, z7, j12, obj25, str15, list8, list10, j13, list11, list12, obj26, obj27, str16, movieImage3, obj28, movieTrailerPreview2, obj29, obj30, obj31, list14, j15, str17, movieGifVideoUrl2, list15, z8, str18, z9, moviePublisher2, j16, j17, (i2 & 1024) != 0 ? movieTrailer.detailKey : obj13, (i2 & 2048) != 0 ? movieTrailer.inlineData : obj14, (i2 & 4096) != 0 ? movieTrailer.statistics : obj15, (i2 & 8192) != 0 ? movieTrailer.viewCount : j8, (i2 & 16384) != 0 ? movieTrailer.overlayImages : obj16, (i2 & 32768) != 0 ? movieTrailer.tags : list7, (i2 & 65536) != 0 ? movieTrailer.tabs : obj17, (i2 & 131072) != 0 ? movieTrailer.goldBadgeImageInfo : obj18, (i2 & 262144) != 0 ? movieTrailer.existInCw : z5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> component18() {
        return this.languages;
    }

    @NotNull
    public final List<MovieLanguagesDetail2> component19() {
        return this.languagesDetails;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> component21() {
        return this.genres;
    }

    @NotNull
    public final List<MovieGenresDetail2> component22() {
        return this.genresDetails;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Object getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Object getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final MovieImage2 getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final MovieTrailerPreview getTrailerPreview() {
        return this.trailerPreview;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Object getTrailer() {
        return this.trailer;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Object getContainer() {
        return this.container;
    }

    @NotNull
    public final List<Object> component32() {
        return this.contributors;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getSubType() {
        return this.subType;
    }

    @NotNull
    /* JADX INFO: renamed from: component35, reason: from getter */
    public final MovieGifVideoUrl getGifVideoUrl() {
        return this.gifVideoUrl;
    }

    @NotNull
    public final List<MovieGifVideoUrlInfo> component36() {
        return this.gifVideoUrlInfo;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @NotNull
    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final boolean getIsOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MovieStream2 getStream() {
        return this.stream;
    }

    @NotNull
    /* JADX INFO: renamed from: component40, reason: from getter */
    public final MoviePublisher getPublisher() {
        return this.publisher;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final long getChildCount() {
        return this.childCount;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final long getVideoCount() {
        return this.videoCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    /* JADX INFO: renamed from: component44, reason: from getter */
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Object getStatistics() {
        return this.statistics;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component47, reason: from getter */
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @NotNull
    public final List<MovieTag> component48() {
        return this.tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component49, reason: from getter */
    public final Object getTabs() {
        return this.tabs;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component50, reason: from getter */
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final boolean getExistInCw() {
        return this.existInCw;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getWatchAt() {
        return this.watchAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @NotNull
    public final MovieTrailer copy(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull MovieStream2 stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> languages, @NotNull List<MovieLanguagesDetail2> languagesDetails, long duration, @NotNull List<String> genres, @NotNull List<MovieGenresDetail2> genresDetails, @Nullable Object secondaryGenres, @Nullable Object publishTime, @NotNull String shareUrl, @NotNull MovieImage2 image, @Nullable Object titleContentImageInfo, @NotNull MovieTrailerPreview trailerPreview, @Nullable Object trailer, @Nullable Object firstVideo, @Nullable Object container, @NotNull List<? extends Object> contributors, long sequence, @NotNull String subType, @NotNull MovieGifVideoUrl gifVideoUrl, @NotNull List<MovieGifVideoUrlInfo> gifVideoUrlInfo, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, @NotNull MoviePublisher publisher, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @NotNull List<MovieTag> tags, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        return new MovieTrailer(description, title, releaseDate, stream, type, tvodPackImageInfo, tvodDetail, watchAt, lastWatched, lastWatchedEpisodeId, subtitleLanguageCode, audioTrackLanguageCode, statusCode, lastTvShowEpisode, rating, descriptor, id, languages, languagesDetails, duration, genres, genresDetails, secondaryGenres, publishTime, shareUrl, image, titleContentImageInfo, trailerPreview, trailer, firstVideo, container, contributors, sequence, subType, gifVideoUrl, gifVideoUrlInfo, canPreviewGifvideo, webUrl, isOptimizedDescription, publisher, childCount, videoCount, detailKey, inlineData, statistics, viewCount, overlayImages, tags, tabs, goldBadgeImageInfo, existInCw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieTrailer)) {
            return false;
        }
        MovieTrailer movieTrailer = (MovieTrailer) other;
        return Intrinsics.areEqual(this.description, movieTrailer.description) && Intrinsics.areEqual(this.title, movieTrailer.title) && Intrinsics.areEqual(this.releaseDate, movieTrailer.releaseDate) && Intrinsics.areEqual(this.stream, movieTrailer.stream) && Intrinsics.areEqual(this.type, movieTrailer.type) && Intrinsics.areEqual(this.tvodPackImageInfo, movieTrailer.tvodPackImageInfo) && Intrinsics.areEqual(this.tvodDetail, movieTrailer.tvodDetail) && this.watchAt == movieTrailer.watchAt && this.lastWatched == movieTrailer.lastWatched && Intrinsics.areEqual(this.lastWatchedEpisodeId, movieTrailer.lastWatchedEpisodeId) && Intrinsics.areEqual(this.subtitleLanguageCode, movieTrailer.subtitleLanguageCode) && Intrinsics.areEqual(this.audioTrackLanguageCode, movieTrailer.audioTrackLanguageCode) && this.statusCode == movieTrailer.statusCode && this.lastTvShowEpisode == movieTrailer.lastTvShowEpisode && this.rating == movieTrailer.rating && Intrinsics.areEqual(this.descriptor, movieTrailer.descriptor) && Intrinsics.areEqual(this.id, movieTrailer.id) && Intrinsics.areEqual(this.languages, movieTrailer.languages) && Intrinsics.areEqual(this.languagesDetails, movieTrailer.languagesDetails) && this.duration == movieTrailer.duration && Intrinsics.areEqual(this.genres, movieTrailer.genres) && Intrinsics.areEqual(this.genresDetails, movieTrailer.genresDetails) && Intrinsics.areEqual(this.secondaryGenres, movieTrailer.secondaryGenres) && Intrinsics.areEqual(this.publishTime, movieTrailer.publishTime) && Intrinsics.areEqual(this.shareUrl, movieTrailer.shareUrl) && Intrinsics.areEqual(this.image, movieTrailer.image) && Intrinsics.areEqual(this.titleContentImageInfo, movieTrailer.titleContentImageInfo) && Intrinsics.areEqual(this.trailerPreview, movieTrailer.trailerPreview) && Intrinsics.areEqual(this.trailer, movieTrailer.trailer) && Intrinsics.areEqual(this.firstVideo, movieTrailer.firstVideo) && Intrinsics.areEqual(this.container, movieTrailer.container) && Intrinsics.areEqual(this.contributors, movieTrailer.contributors) && this.sequence == movieTrailer.sequence && Intrinsics.areEqual(this.subType, movieTrailer.subType) && Intrinsics.areEqual(this.gifVideoUrl, movieTrailer.gifVideoUrl) && Intrinsics.areEqual(this.gifVideoUrlInfo, movieTrailer.gifVideoUrlInfo) && this.canPreviewGifvideo == movieTrailer.canPreviewGifvideo && Intrinsics.areEqual(this.webUrl, movieTrailer.webUrl) && this.isOptimizedDescription == movieTrailer.isOptimizedDescription && Intrinsics.areEqual(this.publisher, movieTrailer.publisher) && this.childCount == movieTrailer.childCount && this.videoCount == movieTrailer.videoCount && Intrinsics.areEqual(this.detailKey, movieTrailer.detailKey) && Intrinsics.areEqual(this.inlineData, movieTrailer.inlineData) && Intrinsics.areEqual(this.statistics, movieTrailer.statistics) && this.viewCount == movieTrailer.viewCount && Intrinsics.areEqual(this.overlayImages, movieTrailer.overlayImages) && Intrinsics.areEqual(this.tags, movieTrailer.tags) && Intrinsics.areEqual(this.tabs, movieTrailer.tabs) && Intrinsics.areEqual(this.goldBadgeImageInfo, movieTrailer.goldBadgeImageInfo) && this.existInCw == movieTrailer.existInCw;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.description.hashCode() * 31) + this.title.hashCode()) * 31) + this.releaseDate.hashCode()) * 31) + this.stream.hashCode()) * 31) + this.type.hashCode()) * 31) + (this.tvodPackImageInfo == null ? 0 : this.tvodPackImageInfo.hashCode())) * 31) + (this.tvodDetail == null ? 0 : this.tvodDetail.hashCode())) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.watchAt)) * 31) + MovieTrailer$$ExternalSyntheticBackport1.m30m(this.lastWatched)) * 31) + (this.lastWatchedEpisodeId == null ? 0 : this.lastWatchedEpisodeId.hashCode())) * 31) + (this.subtitleLanguageCode == null ? 0 : this.subtitleLanguageCode.hashCode())) * 31) + (this.audioTrackLanguageCode == null ? 0 : this.audioTrackLanguageCode.hashCode())) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.statusCode)) * 31) + MovieTrailer$$ExternalSyntheticBackport1.m30m(this.lastTvShowEpisode)) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.rating)) * 31) + (this.descriptor == null ? 0 : this.descriptor.hashCode())) * 31) + this.id.hashCode()) * 31) + this.languages.hashCode()) * 31) + this.languagesDetails.hashCode()) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.duration)) * 31) + this.genres.hashCode()) * 31) + this.genresDetails.hashCode()) * 31) + (this.secondaryGenres == null ? 0 : this.secondaryGenres.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + this.shareUrl.hashCode()) * 31) + this.image.hashCode()) * 31) + (this.titleContentImageInfo == null ? 0 : this.titleContentImageInfo.hashCode())) * 31) + this.trailerPreview.hashCode()) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.firstVideo == null ? 0 : this.firstVideo.hashCode())) * 31) + (this.container == null ? 0 : this.container.hashCode())) * 31) + this.contributors.hashCode()) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.sequence)) * 31) + this.subType.hashCode()) * 31) + this.gifVideoUrl.hashCode()) * 31) + this.gifVideoUrlInfo.hashCode()) * 31) + MovieTrailer$$ExternalSyntheticBackport1.m30m(this.canPreviewGifvideo)) * 31) + this.webUrl.hashCode()) * 31) + MovieTrailer$$ExternalSyntheticBackport1.m30m(this.isOptimizedDescription)) * 31) + this.publisher.hashCode()) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.childCount)) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.videoCount)) * 31) + (this.detailKey == null ? 0 : this.detailKey.hashCode())) * 31) + (this.inlineData == null ? 0 : this.inlineData.hashCode())) * 31) + (this.statistics == null ? 0 : this.statistics.hashCode())) * 31) + MovieTrailer$$ExternalSyntheticBackport0.m29m(this.viewCount)) * 31) + (this.overlayImages == null ? 0 : this.overlayImages.hashCode())) * 31) + this.tags.hashCode()) * 31) + (this.tabs == null ? 0 : this.tabs.hashCode())) * 31) + (this.goldBadgeImageInfo != null ? this.goldBadgeImageInfo.hashCode() : 0)) * 31) + MovieTrailer$$ExternalSyntheticBackport1.m30m(this.existInCw);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieTrailer(description=").append(this.description).append(", title=").append(this.title).append(", releaseDate=").append(this.releaseDate).append(", stream=").append(this.stream).append(", type=").append(this.type).append(", tvodPackImageInfo=").append(this.tvodPackImageInfo).append(", tvodDetail=").append(this.tvodDetail).append(", watchAt=").append(this.watchAt).append(", lastWatched=").append(this.lastWatched).append(", lastWatchedEpisodeId=").append(this.lastWatchedEpisodeId).append(", subtitleLanguageCode=").append(this.subtitleLanguageCode).append(", audioTrackLanguageCode=");
        sb.append(this.audioTrackLanguageCode).append(", statusCode=").append(this.statusCode).append(", lastTvShowEpisode=").append(this.lastTvShowEpisode).append(", rating=").append(this.rating).append(", descriptor=").append(this.descriptor).append(", id=").append(this.id).append(", languages=").append(this.languages).append(", languagesDetails=").append(this.languagesDetails).append(", duration=").append(this.duration).append(", genres=").append(this.genres).append(", genresDetails=").append(this.genresDetails).append(", secondaryGenres=").append(this.secondaryGenres);
        sb.append(", publishTime=").append(this.publishTime).append(", shareUrl=").append(this.shareUrl).append(", image=").append(this.image).append(", titleContentImageInfo=").append(this.titleContentImageInfo).append(", trailerPreview=").append(this.trailerPreview).append(", trailer=").append(this.trailer).append(", firstVideo=").append(this.firstVideo).append(", container=").append(this.container).append(", contributors=").append(this.contributors).append(", sequence=").append(this.sequence).append(", subType=").append(this.subType).append(", gifVideoUrl=");
        sb.append(this.gifVideoUrl).append(", gifVideoUrlInfo=").append(this.gifVideoUrlInfo).append(", canPreviewGifvideo=").append(this.canPreviewGifvideo).append(", webUrl=").append(this.webUrl).append(", isOptimizedDescription=").append(this.isOptimizedDescription).append(", publisher=").append(this.publisher).append(", childCount=").append(this.childCount).append(", videoCount=").append(this.videoCount).append(", detailKey=").append(this.detailKey).append(", inlineData=").append(this.inlineData).append(", statistics=").append(this.statistics).append(", viewCount=").append(this.viewCount);
        sb.append(", overlayImages=").append(this.overlayImages).append(", tags=").append(this.tags).append(", tabs=").append(this.tabs).append(", goldBadgeImageInfo=").append(this.goldBadgeImageInfo).append(", existInCw=").append(this.existInCw).append(')');
        return sb.toString();
    }

    public MovieTrailer(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull MovieStream2 stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> list, @NotNull List<MovieLanguagesDetail2> list2, long duration, @NotNull List<String> list3, @NotNull List<MovieGenresDetail2> list4, @Nullable Object secondaryGenres, @Nullable Object publishTime, @NotNull String shareUrl, @NotNull MovieImage2 image, @Nullable Object titleContentImageInfo, @NotNull MovieTrailerPreview trailerPreview, @Nullable Object trailer, @Nullable Object firstVideo, @Nullable Object container, @NotNull List<? extends Object> list5, long sequence, @NotNull String subType, @NotNull MovieGifVideoUrl gifVideoUrl, @NotNull List<MovieGifVideoUrlInfo> list6, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, @NotNull MoviePublisher publisher, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @NotNull List<MovieTag> list7, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        this.description = description;
        this.title = title;
        this.releaseDate = releaseDate;
        this.stream = stream;
        this.type = type;
        this.tvodPackImageInfo = tvodPackImageInfo;
        this.tvodDetail = tvodDetail;
        this.watchAt = watchAt;
        this.lastWatched = lastWatched;
        this.lastWatchedEpisodeId = lastWatchedEpisodeId;
        this.subtitleLanguageCode = subtitleLanguageCode;
        this.audioTrackLanguageCode = audioTrackLanguageCode;
        this.statusCode = statusCode;
        this.lastTvShowEpisode = lastTvShowEpisode;
        this.rating = rating;
        this.descriptor = descriptor;
        this.id = id;
        this.languages = list;
        this.languagesDetails = list2;
        this.duration = duration;
        this.genres = list3;
        this.genresDetails = list4;
        this.secondaryGenres = secondaryGenres;
        this.publishTime = publishTime;
        this.shareUrl = shareUrl;
        this.image = image;
        this.titleContentImageInfo = titleContentImageInfo;
        this.trailerPreview = trailerPreview;
        this.trailer = trailer;
        this.firstVideo = firstVideo;
        this.container = container;
        this.contributors = list5;
        this.sequence = sequence;
        this.subType = subType;
        this.gifVideoUrl = gifVideoUrl;
        this.gifVideoUrlInfo = list6;
        this.canPreviewGifvideo = canPreviewGifvideo;
        this.webUrl = webUrl;
        this.isOptimizedDescription = isOptimizedDescription;
        this.publisher = publisher;
        this.childCount = childCount;
        this.videoCount = videoCount;
        this.detailKey = detailKey;
        this.inlineData = inlineData;
        this.statistics = statistics;
        this.viewCount = viewCount;
        this.overlayImages = overlayImages;
        this.tags = list7;
        this.tabs = tabs;
        this.goldBadgeImageInfo = goldBadgeImageInfo;
        this.existInCw = existInCw;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final MovieStream2 getStream() {
        return this.stream;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    public final long getWatchAt() {
        return this.watchAt;
    }

    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @Nullable
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    public final long getStatusCode() {
        return this.statusCode;
    }

    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    public final long getRating() {
        return this.rating;
    }

    @Nullable
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getLanguages() {
        return this.languages;
    }

    @NotNull
    public final List<MovieLanguagesDetail2> getLanguagesDetails() {
        return this.languagesDetails;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final List<MovieGenresDetail2> getGenresDetails() {
        return this.genresDetails;
    }

    @Nullable
    public final Object getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @Nullable
    public final Object getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    public final MovieImage2 getImage() {
        return this.image;
    }

    @Nullable
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @NotNull
    public final MovieTrailerPreview getTrailerPreview() {
        return this.trailerPreview;
    }

    @Nullable
    public final Object getTrailer() {
        return this.trailer;
    }

    @Nullable
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @Nullable
    public final Object getContainer() {
        return this.container;
    }

    @NotNull
    public final List<Object> getContributors() {
        return this.contributors;
    }

    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    public final String getSubType() {
        return this.subType;
    }

    @NotNull
    public final MovieGifVideoUrl getGifVideoUrl() {
        return this.gifVideoUrl;
    }

    @NotNull
    public final List<MovieGifVideoUrlInfo> getGifVideoUrlInfo() {
        return this.gifVideoUrlInfo;
    }

    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    public final boolean isOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    @NotNull
    public final MoviePublisher getPublisher() {
        return this.publisher;
    }

    public final long getChildCount() {
        return this.childCount;
    }

    public final long getVideoCount() {
        return this.videoCount;
    }

    @Nullable
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    public final Object getStatistics() {
        return this.statistics;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @NotNull
    public final List<MovieTag> getTags() {
        return this.tags;
    }

    @Nullable
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    public final boolean getExistInCw() {
        return this.existInCw;
    }
}
